SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss zZ yyyy", Locale.ENGLISH);
try{
   date = formatter.parse(s);
   System.out.println(date);
}catch(ParseException ex){
  //exception
  ex.printStackTrace();
}