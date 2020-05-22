Date date= new Date();

 long time = date.getTime();

 Calendar cal = Calendar.getInstance(Locale.ENGLISH);
    cal.setTimeInMillis(time * 1000);
    String date = DateFormat.format("dd-MM-yyyy", cal).toString();