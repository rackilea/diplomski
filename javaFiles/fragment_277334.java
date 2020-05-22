String sDate = "31012014";
SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy", Locale.getDefault());
Date date = dateFormat.parse(sDate);
Calendar calendar = Calendar.getInstance();
calendar.setTime(date);
calendar.add(Calendar.DATE, -1);
String yesterdayAsString = dateFormat.format(calendar.getTime());