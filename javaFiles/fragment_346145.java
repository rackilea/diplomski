use strict;
use warnings 'all';
use feature 'state';

@ARGV = 'f1.txt';

my ( $heb, $heh, @her );

my @records;

while ( <> ) {

    my ($item) = split;

    die unless my ($type) = $item =~ /^(HE[BHRTE])/;

    state $dispatch = {
        HEB => sub {
            $heb = shift;
            $heh = undef;
            @her = ();
        },
        HEH => sub {
            $heh = shift;
            @her = ();
        },
        HER => sub {
            push @her, shift;
        },
        HET => sub {
            my $het      = shift;
            my $filename = $ARGV;
            push @records, [ $het, $heh, @her, $heb, $filename ];
            @her = ();
        },
        HEE => sub {

            my $hee = shift;

            for my $rec (@records) {
                push @$rec, $hee;
                print "@$rec\n";
            }

            $heb = $heh = undef;
            @her = ();
            @records = ();
        },
    };

    $dispatch->{$type}->($item);
}