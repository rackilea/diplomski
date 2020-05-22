#!/usr/bin/env perl
use warnings;
use Cwd;

my $cwd = cwd();    

print "dada\n";
print "In folder: $cwd";
$file = "settings.txt";
open ($ds, "<", $file) || die "Can't open settings.txt. Error code: $!";
print "doudou\n";

while ($line = <$ds>){
    print "$line\n";
    last if $. == 4;
}

print "dodo\n";
close $ds;