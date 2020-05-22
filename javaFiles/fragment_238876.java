public class Test {
  public static void main (String[] args) {

        String myString = "BF800000";
        Long i = Long.parseLong(myString, 16);
        Float f = Float.intBitsToFloat(i.intValue());
        System.out.println(f);
        System.out.println(Integer.toHexString(Float.floatToIntBits(f)));
  }
}