String input = "Thu Jan 18 00:00:00 CET 2018";

DateFormat parser = new SimpleDateFormat("E MMM dd HH:mm:ss x yyyy", Locale.US);
Date date = parser.parse(input); // parse String to Date

DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
System.out.println(formatter.format(date)); // format Date to String