String date="2017-04-04T20:22:33";
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
 SimpleDateFormat sdf1 = new SimpleDateFormat("MMM-dd HH:mm");
 try{
    Date parseDate = sdf.parse(date);
    String output = sdf1.format(parseDate);
 }catch(Exception e) {

 }