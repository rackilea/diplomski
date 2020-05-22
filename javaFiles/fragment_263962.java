ULocale locale = new ULocale("@calendar=islamic");
Calendar islamicCalendar = Calendar.getInstance(locale);

// full date
DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
System.out.println(df.format(islamicCalendar.getTime()));

// date in "yyyy MMM dd" format
SimpleDateFormat df1 = new SimpleDateFormat ("yyyy MMM dd", locale);
System.out.println(df1.format(islamicCalendar.getTime()));

// name of month 
SimpleDateFormat df2 = new SimpleDateFormat (SimpleDateFormat.MONTH, locale);
System.out.println(df2.format(islamicCalendar.getTime()));

// name of weekday
SimpleDateFormat df3 = new SimpleDateFormat (SimpleDateFormat.WEEKDAY, locale);
System.out.println(df3.format(islamicCalendar.getTime()));