SimpleDateFormat sf1= new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sf2= new SimpleDateFormat("dd.MM.yyyy");
    Date date1=sf1.parse("2016-07-18");
    Date date2=sf2.parse("18.07.2016");
    boolean bol=date1.compareTo(date2)==0;
    System.out.println(bol);//true if two dates are equal, false if two date are not equal