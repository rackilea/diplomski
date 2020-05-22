public static void main(String[] args) throws FileNotFoundException, ParseException {
    String string = "Temp_2014_09_19_01_00_00.csv";
    SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd");
    Pattern p = Pattern.compile("\\d\\d\\d\\d_\\d\\d_\\d\\d");
    Matcher m = p.matcher(string);
    Date tempDate = null;
    if(m.find())
    {
        tempDate = format.parse(m.group());
    }
    System.out.println("" + tempDate);
}