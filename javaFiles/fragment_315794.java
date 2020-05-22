// new Calendar represents current time
Calendar cal = Calendar.getInstance();

// subtract five days
cal.add(Calendar.DATE, -5);

// specify format required
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS); // or whatever format you want

// format the date and add the prefix and suffix
String formattedDate = "<FechaDesde>" + sdf.format(cal.getTime()) + "</FechaDesde>";