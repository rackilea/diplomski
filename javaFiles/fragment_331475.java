Calendar cal = Calendar.getInstance(Locale.ENGLISH);
System.out.println(sdf.format(cal.getTime()));
// Cloning so that Calendar could be re-used
Calendar calEnd = (Calendar) cal.clone();
// Setting start of the week date
cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
System.out.println(sdf.format(cal.getTime()));
calEnd.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
System.out.println(sdf.format(calEnd.getTime()));