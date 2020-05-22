java.text.DateFormat formatter = new    java.text.SimpleDateFormat("M/d/yyyy",Locale.US);
     String dateInString = d1;
    if(d1.trim().length()>0)
    {
    Date date = formatter.parse(dateInString);
    if(todaydate.compareTo(date)>0)
    {
    printOut(name+";"+formatter.format(date));
     }
    }