String year;
String str = // your csv line
String[] strArr = str.split(",");
for(String s : strArr)
{
    if(s.trim().matches("2\\d{3}"))
    {
        year = s;
        break;
    }
}