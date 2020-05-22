public TicketSeller(int initialTicketAllotment) {
    this.initialTicketAllotment = initialTicketAllotment;
    // you need to initialize 'placeholder' to the initial
    // amount of tickets available
    this.placeholder = initialTicketAllotment;
}

public int requestTickets(int ticketRequest) {
    // you should check if there are no more tickets to request
    // or more than MAXIMUM_TICKETS_ALLOWED (4 tickets) have been
    // requested, before checking if placeholder > 0. Also, you
    // want to check if 'ticketRequest > placeholder' not the
    // initial amount of tickets.
    if (ticketRequest > MAXIMUM_TICKETS_ALLOWED
            || ticketRequest > placeholder) {
        return TOO_MANY_TICKETS_REQUESTED;
    }

    // remove the local 'value' variable, it just confuses your
    // code to other readers, thinking you need a temporary variable
    // for some reason
    if (placeHolder > 0) {
        placeholder -= ticketRequest;
        buyers += 1;
    }

    // if placeholder equals 0, that means there are no more tickets
    // left... not sure why you would set it back to
    // 'initialTicketAllotment - ticketRequest'. I would get rid of this
    // method.
    /*
    if (ticketRequest >= 0 && ticketRequest <= MAXIMUM_TICKETS_ALLOWED
            && placeHolder == 0) {
        int value = 0;
        value = initialTicketAllotment - ticketRequest;
        placeHolder = value;
        buyers += 1;
    }
    */

    return placeHolder;
}