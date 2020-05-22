public static bool isTimeStampValid(String inputString)
{ 
    SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
    try{
       format.parse(inputString);
       return true;
    }
    catch(ParseException e)
    {
        return false;
    }
}