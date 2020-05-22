DateFormat f = new SimpleDateFormat("dd/M/yyyy");   
    String indate = "13/1/2011";
    Date cd1 = f.parse(indate);
    String currentDate ="1/14/2011";
    DateFormat f2 = new SimpleDateFormat("M/dd/yyyy");
    Date cd2 = f2.parse(currentDate);
    if (cd1.before(cd2))
    {
        check ="1";
    }