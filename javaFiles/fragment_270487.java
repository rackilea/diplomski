public class StringUtils{
     public static String repeat(String val, int count){
          StringBuilder buf = new StringBuilder(val.length() * count);
          while (count-- > 0) {
               buf.append(val);
          }
          return buf.toString();
     }
}