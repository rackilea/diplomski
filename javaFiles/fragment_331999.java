#!/usr/bin/perl

use strict;
use warnings;

use Regex::PreSuf;

my %singledigit = (
    one    => 1,
    two    => 2,
    three  => 3,
    four   => 4,
    five   => 5,
    six    => 6,
    seven  => 7,
    eight  => 8,
    nine   => 9,
);

my $singledigit = presuf(keys %singledigit);

print $singledigit, "\n";

my $text = "one two three four five six seven eight nine";

$text =~ s/($singledigit)/$singledigit{$1}/g;

print $text, "\n";