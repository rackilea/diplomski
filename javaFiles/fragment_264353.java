SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
java.util.Date date = null;
try 
{
    date = form.parse("2011-03-27T09:39:01.607");
}
catch (ParseException e) 
{

    e.printStackTrace();
}
SimpleDateFormat postFormater = new SimpleDateFormat("MMMMM dd, yyyy");
String newDateStr = postFormater.format(date);