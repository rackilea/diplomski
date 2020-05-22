use warnings;
use strict;

die "Usage: $0 INFILE OUTFILE\n" unless @ARGV==2;
my $INFILE  = $ARGV[0];
my $OUTFILE = $ARGV[1];

open my $ifh, '<', $INFILE  or die "$INFILE: $!";
open my $ofh, '>', $OUTFILE or die "$OUTFILE: $!";
while (<$ifh>) {
    print $ofh lc;
}
close $ifh;
close $ofh;