Date dateOne=null,dateTwo=null;
    try {
        dateOne = new SimpleDateFormat( "yyyy-MM-dd" ).parse("2016-3-21");
        dateTwo =  new SimpleDateFormat( "yyyy-MM-dd" ).parse("1989-3-21");
    } 
    catch (ParseException ex) {     
    }
    System.out.println( getTimeDiff(dateOne,dateTwo));



    public String getTimeDiff(Date dateOne, Date dateTwo) {
        String diff = "";
        long timeDiff = Math.abs(dateOne.getTime() - dateTwo.getTime());
        diff = String.format("%d date(s) ", TimeUnit.MILLISECONDS.toDays(timeDiff));
        return diff;
    }