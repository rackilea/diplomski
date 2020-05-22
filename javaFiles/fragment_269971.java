public static Date getAlphabetDate()
{
    try
    {
        String tempDate = month + "/" + day;
        Date alphabetDate = new SimpleDateFormat("MM/dd").parse(tempDate);
        return alphabetDate;
    }
    catch(Exception e)
    {
        return null;
    }
}