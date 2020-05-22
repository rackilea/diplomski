DateFormat df = new SimpleDateFormat("mm/dd/yyyy");

try
{
   df.parse("01/05/2014");
}
catch(Exception e)
{
  //not a date
}