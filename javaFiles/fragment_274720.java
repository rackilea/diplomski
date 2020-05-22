import org.joda.time.DateTime;
    import org.joda.time.format.DateTimeFormat;
    import org.joda.time.format.DateTimeFormatter;
    ...

    // if default locale is ok simply omit '.withLocale(...)'
    DateTimeFormatter format = DateTimeFormat.forPattern("MMM");
    DateTime instance        = format.withLocale(Locale.FRENCH).parseDateTime("août");  

    int month_number         = instance.getMonthOfYear();
    String month_text        = instance.monthOfYear().getAsText(Locale.ENGLISH);

    System.out.println( "Month Number: " + month_number );
    System.out.println( "Month Text:   " + month_text   );

    OUTPUT:
        Month Number: 8
        Month Text:   August