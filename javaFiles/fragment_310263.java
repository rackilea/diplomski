public static void main(String[] args) {

      System.out.println("-----Formatted Past Three Days-----");
        List<Date> pastThreeDatesList = getPastThreeDays();
        for (Date date : pastThreeDatesList) {
           System.out.println("Orignal:"+date);

          long mDateMills= date.getTime() - ((5*3600 *1000)+ 45*60*1000); //you convert your date to millisecond then subtract 5h45min( in milliseconds from it)
          String  mNewDate= millsToDateFormat(mDateMills);

          System.out.println("new Date:"+mNewDate);
        }
}

public static String millsToDateFormat(long mills) {

        Date date = new Date(mills);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateFormatted = formatter.format(date);
        return dateFormatted; 
    }