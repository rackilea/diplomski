public class Foo001 {
   // private static final String REGEX1 = "\\b";
   private static final String REGEX2 = "(?= )|(?<= )";

   public static void main(String[] args) {
      String str = " 0 +Ve";

      String[] tokens = str.split(REGEX2);
      for (int i = 0; i < tokens.length; i++) {
         System.out.printf("token %d: \"%s\"%n", i, tokens[i]);
      }

   }
}