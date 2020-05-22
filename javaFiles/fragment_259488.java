Date a = new Date("21/03/2000");
    Date b = new Date("21/03/2006");
    Date c = new Date("18/09/2008");

    List<Date> dateList = new ArrayList<Date>();

    Date date = new Date("18/09/2005");

    dateList.add(a);
    dateList.add(b);
    dateList.add(c);

    for (Date minDate : dateList) {
        for (Date maxDate : dateList) {
            //System.out.println(" After "+date.after(minDate));
            //System.out.println(" Before "+date.before(maxDate));
            System.out.println(" Date " + date + " is After "+ minDate+ " and Before "+ maxDate + " : "+  String.valueOf(date.after(minDate) && date.before(maxDate)) );

        }
    }