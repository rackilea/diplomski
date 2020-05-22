String theInDate = "2/20/2016";

    String theInFormat = "M/d/yyyy";
    String theOutFormat = "MMM dd, yyyy";

    final DateTimeFormatter theSdfInputFormatter = DateTimeFormatter.ofPattern( theInFormat );
    final DateTimeFormatter theSdfOutputFormatter = DateTimeFormatter.ofPattern(theOutFormat);

    final LocalDate theDate = LocalDate.from( theSdfInputFormatter.parse( theInDate ) );

    final String theDateText = theSdfOutputFormatter.format(theDate);

    System.out.println(theDateText);