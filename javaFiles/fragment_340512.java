SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date startDate = dateFormat.parse("01/01/2012");
    Date endDate = dateFormat.parse("31/12/2012");
    Date dateLine = dateFormat.parse("01/01/2012");
    boolean result = false;     
    if ((startDate.equals(dateLine) || !endDate.equals(dateLine))
            || (startDate.after(dateLine) && endDate.before(dateLine)))  { // equal to start or end date or with in period
        result = true;
    }   
    System.out.println(result);