// 24 hours format
SimpleDateFormat df = new SimpleDateFormat("HH:mm");
// AM/PM format
SimpleDateFormat df = new SimpleDateFormat("hh:mm aa");

System.out.println(df.format(now.getTime()));