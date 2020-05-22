public static boolean validateDateRange(String startDate,String EndDate,String extension){  
    if(startDate.equals("NA")||EndDate.equals("NA")){
        return true;
    }

    boolean x = extension.equalsIgnoreCase("Y");

    Date d1 = null;
    Date d2 = null;
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    try {
        d1 = format.parse(startDate);
        d2 = format.parse(EndDate);
        long diff = d2.getTime()- d1.getTime();//in Milli seconds
        long numOfDays = diff/(1000*60*60*24);
        System.out.println(numOfDays);

        return !((!x && numOfDays > 14) || numOfDays > 28);
    } catch (ParseException e) { // maybe rethrow exception?
        e.printStackTrace();
    }

    return true;
}