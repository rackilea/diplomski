public static void main(String[] args)
{
    String dthours = "07:4856:35563333";
    SimpleDateFormat df = new SimpleDateFormat("HH:MM:SS");
    df.setLenient(false);
    try
    {
        Date d = df.parse(dthours);
        System.out.println("d = " + d);
    }
    catch (ParseException e)
    {
        System.out.println("parseError");
    }
}