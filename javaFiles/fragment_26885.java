use warnings;
use strict;

my %graph;
sub add_edge {
    my ($n1, $n2) = @_;
    $graph{$n1}{$n2} = 1;
    $graph{$n2}{$n1} = 1;
}

sub show_edges {
    foreach my $n1 (keys %graph) {
        foreach my $n2 (keys %{$graph{$n1}}) {
            print "$n1 <-> $n2\n";
        }
    }
}

while (<>) {
    my ($n1, $n2) = split /\s+/;
    add_edge($n1, $n2);
}

show_edges();