class pi_bytes
{
   public static void main(String[] a)
   {
      System.out.printf("%016x\n", Double.doubleToRawLongBits( Math.PI ) );
   }
}