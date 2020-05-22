// Get a calendar which is set to a specified date.
Calendar calendar = new GregorianCalendar(2009, Calendar.JANUARY, 1);

// Get the current date representation of the calendar.
Date startDate = calendar.getTime();

// Increment the calendar's date by 1 day.
calendar.add(Calendar.DAY_OF_MONTH, 1);

// Get the current date representation of the calendar.
Date endDate = calendar.getTime();

System.out.println(startDate);
System.out.println(endDate);