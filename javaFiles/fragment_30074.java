public static void main (String[] args){
   SimpleDateFormat dateFormatUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
   dateFormatUTC.setTimeZone(TimeZone.getTimeZone("UTC"));

   System.out.println("time: " + dateFormatUTC.format(new Date(Double.valueOf("1.484728135674E9").longValue() * 1000)));
   System.out.println("date: " + dateFormatUTC.format(new Date(Double.valueOf("1.474555072424E9").longValue() * 1000)));
}