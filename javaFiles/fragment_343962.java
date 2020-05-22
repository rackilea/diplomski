class Test {
   public static void main(String... args) {
      String s1 = "Good";
      s1 = s1 + "morning";

      String s2 = "Goodmorning";
      System.out.println(s1.intern());  //just changed here s1.intern() and the if condition runs true   

      if(s1 == s2) {
         System.out.println("both are equal");
      } //now it works.
   }
}