public class HelloWorld
{
    public static void main(String[] args)
    {
       // The triple backslash is data author's attempt to escape the double-quote.
       String s = "50°32'20.548\\\"N";

       // Get rid of any residual backslashes
       s = s.replace("\\","");

       // split string into constituent parts using apparent separators
       String[] dms = s.split("[°'\"]");

       // form 'newS' which complies with Location.FORMAT_SECONDS
       String newS = dms[0]+":"+dms[1]+":"+dms[2];

       // and grab hemisphere (to implement sign)
       String hemi = dms[3];

       double coord = Location.convert(newS);
       if (hemi.compareTo("W") == 0 || hemi.compareTo("S") == 0) {
           coord = -coord;
       }
   }