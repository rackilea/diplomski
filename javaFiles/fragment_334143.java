import java.text.DecimalFormat;

public class Foo {
   private static final String FORMAT_STRING = "0";

   public static void main(String[] args) {
      DecimalFormat myFormat = new DecimalFormat(FORMAT_STRING);
      myFormat.setGroupingSize(3);
      myFormat.setGroupingUsed(true);

      System.out.println(myFormat.format(10000000000000L));
   }
}