public class App 
{
    public static void main( String[] args ) throws UnsupportedEncodingException
    {

       String sideOneString = "Effects of BOTOX® may spread";
       String sideTwoString = "Effects of BOTOX\\xc2\\xae may spread";
       String sideThreeString = "BOTOX injections take about\n15 mins";
       String sideFourString  = "BOTOX\\xc2\\xae injections take about\\n15 mins";


       System.out.println( hashMyString(cleanTextContent(sideOneString)));
       System.out.println( hashMyString(cleanTextContent(sideTwoString)));
       System.out.println( hashMyString(cleanTextContent(sideThreeString)));
       System.out.println( hashMyString(cleanTextContent(sideFourString)));
    }





    private  static  String hashMyString(String text)  {

        String hashText= text;

        String md5Hex = DigestUtils.md5Hex(hashText).toUpperCase();
        //System.out.println(md5Hex);
       return md5Hex;
    }

    private static String cleanTextContent(String text)
    {
        // strips off all non-ASCII characters
        text = text.replaceAll("[^\\x00-\\x7F]", "");

        // erases all the ASCII control characters
        text = text.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");

        // removes non-printable characters from Unicode
        text = text.replaceAll("\\p{C}", "");

        text = text.replaceAll("[^ -~]","");

        text = text.replaceAll("[^\\p{ASCII}]", "");

        text = text.replaceAll("\\\\x\\p{XDigit}{2}", "");
        text = text.replaceAll("\\\\n","");


        text = text.replaceAll("[^\\x20-\\x7e]", "");
        return text.trim();
    }
}