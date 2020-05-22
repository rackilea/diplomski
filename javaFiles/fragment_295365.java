try
{
SimpleDateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
f.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
Date time = f.parse("20161015113634");  


DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
formatter.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));

System.out.println(formatter.format(time)); 
}
catch (ParseException e){

}