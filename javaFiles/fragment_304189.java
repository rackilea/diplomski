import  java.util.Map;
import  java.util.HashMap;
import  java.util.regex.Pattern;
import  java.util.regex.Matcher;

public class Replacement  {
   public static final void main(String[] ignored)  {

      String str = "fname:hello hello:world ffff:off";
      Map<String, String> mapping = new HashMap<String, String>();
      mapping.put("fname", "meme");
      mapping.put("hello", "below");
      mapping.put("ffff", "ssss");
      Pattern pat = Pattern.compile("([a-zA-Z_]+):");

      Matcher m = pat.matcher(str);


      StringBuffer sb = new StringBuffer();
      while(m.find())  {
         String rplcWith = mapping.get(m.group(1));
         m.appendReplacement(sb, rplcWith + ":");
      }
      m.appendTail(sb);

      System.out.println(sb);
   }
}