SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()); //My locale is CEST
Date dateOfBooking = formatter.parse(bookedDate + " " + bookedDateTime); //Here the time is 10:09

DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
timeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
bookedDateTime = timeFormat.format(dateOfBooking);
System.out.println(bookedDateTime);