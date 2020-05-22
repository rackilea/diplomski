DateFormat newDateFormat = new SimpleDateFormat("HH:mm");    

Date d1 = newDateFormat.parse("12:12");
Date d2 = newDateFormat.parse("13:13");
Date myDate = newDateFormat.parse("12:15");

if(myDate.getTime() >= d1.getTime() && myDate.getTime() <= d2.getTime()){
//yes it is in between  including border
}