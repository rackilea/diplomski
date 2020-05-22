public class Key {

   private String keyA;
   private String keyB;
   private String keyC;

   public Key(String a, String b, String c) {
      keyA = "".equals(a) ? null : a;
      keyB = "".equals(b) ? null : b;
      keyC = "".equals(c) ? null : c;
   }

   public String getKey(){
      return keyA + keyB + keyC;
   }

   // equals() can be implemented using getKey()
}