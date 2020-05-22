SimpleDateFormat dateParser= new SimpleDateFormat("yyyyMMddHHmmss");
SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
String dateID = "20160729161455";

try
{
    Date date = dateParser.parse(dateID);
    System.out.println(dateFormatter.format(date));
} catch (ParseException ex){
    ex.printStacktrace();
}