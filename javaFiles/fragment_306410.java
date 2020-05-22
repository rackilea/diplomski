# Add the first sentence/line from the log message.
unless ($self->{no_first_line}) {

    # Abort if log message ends with _
    exit if ($self->{message}[0] =~ /_\s*$/);

    # Truncate to first period after a minimum of 10 characters.
    my $i = index substr($self->{message}[0], 10), '. ';
    $self->{subject} .= $i > 0
        ? substr($self->{message}[0], 0, $i + 11)
        : $self->{message}[0];
}