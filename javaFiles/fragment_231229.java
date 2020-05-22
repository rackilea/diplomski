#!/usr/bin/perl
use strict;

if (@ARGV != 2) {
  print STDERR "Usage: $0 OUTFILE CLASSPATHSTRING\n";
  print STDERR "e.g., $0 .classpath path1:path2:path3\n";
  exit 1;
}

my $OUTFILE         = $ARGV[0];
my $CLASSPATHSTRING = $ARGV[1];

open my $out_fh, '>', $OUTFILE or die "Couldn't open output file: $!";

print $out_fh q{<?xml version="1.0" encoding="UTF-8"?>
<classpath>
    <classpathentry kind="src" path="src"/>
    <classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER"/>
    <classpathentry kind="output" path="build"/>
};

my @libs = split(":", $CLASSPATHSTRING);
foreach my $thisLib (@libs){
    print $out_fh "    <classpathentry kind=\"lib\" path=\"$thisLib\"/>\n";
}
print $out_fh "</classpath>\n";