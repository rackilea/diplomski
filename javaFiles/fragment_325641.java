String dateString="2018-09-20T11:44:48.000Z";

   SimpleDateFormat inputFormat     = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'");
   SimpleDateFormat outputFormat    = new SimpleDateFormat("MM/dd/yyyy'T'HH:mm:ss.S'Z'");

    Date   convertedDate    = null;
    String strOP            = null;

    try 
    {
        convertedDate = inputFormat.parse(dateString);
        strOP         = outputFormat.format(convertedDate);
        textTime.setReferenceTime(strOP);
    } 
    catch (ParseException e) 
    {
        e.printStackTrace();
    }