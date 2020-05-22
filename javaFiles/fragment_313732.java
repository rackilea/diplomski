String s;
    DateFormat formatter;        

    formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = formatter.parse("2013-07-17");
    formatter = new SimpleDateFormat("yyMMdd");
    s = formatter.format(date1);
    System.out.println(s);