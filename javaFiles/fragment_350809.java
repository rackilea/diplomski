TimeZone tz = TimeZone.getTimeZone("GMT+05:30");
Calendar c = Calendar.getInstance(tz);
String time = String.format("%02d" , c.get(Calendar.HOUR_OF_DAY))+":"+
            String.format("%02d" , c.get(Calendar.MINUTE))+":"+
.                   String.format("%02d" , c.get(Calendar.SECOND))+":"+
    .           String.format("%03d" , c.get(Calendar.MILLISECOND));