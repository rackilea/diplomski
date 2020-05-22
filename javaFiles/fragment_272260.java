#!/usr/bin/env perl
use strict;  
use warnings;

$| = 1;

my $command = "/usr/java/jdk6/bin/java -jar  runner-0.0.1-SNAPSHOT.jar @ARGV";
open ( my $java_output, '|-', $command ); 

while ( my $line = <$java_output> ) {
    print $line; 
}
close ( $java_output );