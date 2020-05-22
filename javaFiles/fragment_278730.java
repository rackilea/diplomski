my $result = open2( *Reader, *Writer, $command )
               or die "Could not open 2-way pipe: $!\n";

do { ... }; # Interact with the process

waitpid( $result, 0 );

my $result_return_code = $? >> 8;