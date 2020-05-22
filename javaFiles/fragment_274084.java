NumberFormat formatter = NumberFormat.getInstance(new Locale("en_US"));

    try {
        System.out.println(formatter.parse("1,000.0"));
    } catch (ParseException e) {
        // Handle this
    }