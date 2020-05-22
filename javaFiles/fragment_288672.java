public static void main(String[] args) {

   int total = 0;
   int col   = 0;

   // table heading
   System.out.println("     Integers from 300 to 200");

   System.out.println("   -----------------------------");

   for (int high = 300; high >= 200 && high <= 300;) {
       if ((high % 11 == 0) != (high % 13 == 0)) {

           if (col == 5) {
               System.out.println();
               col = 0;
           }

           System.out.printf("%-8d", high);
           total += high;
           col++;
       }
       high = high - 1;
   }
}