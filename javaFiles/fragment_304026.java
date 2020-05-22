List dates = [ "16:15", "12:30 PM", "07:00", "03:00 AM" ]

dates.sort { d ->
  [ 'h:mm a', 'H:mm' ].findResult { fmt ->
    try {
      Date.parse( fmt, d ).time
    } catch( e ) {}
  }
}