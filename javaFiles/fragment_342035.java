try
 {
    String currentDate = "2014-10-01 00:00:00.0";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
    Date tempDate=simpleDateFormat.parse(currentDate);
    SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM.YYYY");           
    System.out.println("Output date is = "+outputDateFormat.format(tempDate));
  } catch (ParseException ex) 
  {
        System.out.println("Parse Exception");
  }