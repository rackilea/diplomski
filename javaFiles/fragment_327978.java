import java.math.BigInteger;

class Test {
   public static void main(String[] args) {
       byte[] bytes = new byte[8192/8];
       bytes[0] = 127;
       System.out.println(new BigInteger(bytes));
   }
}