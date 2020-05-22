date = aDate;
String[] str = date.split("/");
String sMonth = str[0];
String sDay = str[1];
String sYear = str[2];

try
{
    // Here you compare String to an int, do the convertions to int first
    // to make it throw exception on non integers.
    if (month <= 12 && day <= 31)
    {
        month = month = Integer.parseInt(sMonth);
        day = Integer.parseInt(sDay); 
    }
    if (sYear.length() != 4)
    {
    year = Integer.parseInt(sYear);
    }
}
catch (Exception e)
{
   month = 0;
   day = 0;
   year = 0; 
}