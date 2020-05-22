// Instantiate a Date object
Date startDate = new GregorianCalendar(2015, 8, 20).getTime();

// Calculate end date (+1 day)
Calendar endDate = Calendar.getInstance();
endDate.setTime(startDate);
endDate.add(Calendar.DATE, 1); // Add 1 day

// format dates the same way logs use
SimpleDateFormat ft = 
    new SimpleDateFormat ("y-M-d");

// Create regex
String datesRegex = "^(?:" + ft.format(startDate) + "|" + ft.format(endDate.getTime()) + ") .*";