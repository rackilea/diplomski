//convert datetime to give timezone 
    private static String DateTimeConverter (String timeVal, String timeZone)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    SimpleDateFormat offsetDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        offsetDateFormat2.setTimeZone(TimeZone.getTimeZone(timeZone));
        String result =null;
        try {
            result = offsetDateFormat2.format(format.parse(timeVal));
        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }