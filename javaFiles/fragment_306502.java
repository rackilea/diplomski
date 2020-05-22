// get current time
    // you could just as well use Date now = new Date();
    Calendar now = Calendar.getInstance();

    // Locale for formatter
    Locale malaysianLocale = new Locale("ms", "MY");
    // Default date and time format for Malaysia
    DateFormat defaultMalaysianFormatter = DateFormat.getDateTimeInstance(
            DateFormat.DEFAULT, DateFormat.DEFAULT, malaysianLocale);
    // This step is crucial
    TimeZone malaysianTimeZone = TimeZone.getTimeZone("Asia/Kuala_Lumpur");
    defaultMalaysianFormatter.setTimeZone(malaysianTimeZone);

    System.out.println(defaultMalaysianFormatter.format(now.getTime()));