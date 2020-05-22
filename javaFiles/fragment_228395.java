public static void main(String[] args)
{
   Random rand = new Random();
   for ( int j = 0; j < 5; ++j)
   {
      int num = rand.nextInt(10);
      for ( int i = 0; i <= num; ++i )
      {
         System.out.print('*');
      }
      System.out.println();
   }
}