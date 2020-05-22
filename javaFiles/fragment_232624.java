public class Task2 {
   public static void main(String args[]) {
      String str = "abc";
      str = pad(str, 10, '*');
      System.out.println(str);
   }

   public static String pad(String base, int n, char c) {
      while (base.length() < n) {
         base = base + c;
      }
      return base;
   }
}