public static void main(String[] args) 
{
    Random rand = new Random();

    int position = 0;
    int stepsTotal = 0;
    int zeroesTotal = 0;

     while (position != -10 && position != 10) {
         if (rand.nextDouble() < 0.5) {
             position--; 
         }
         else {
             position++; 
         }

         if (position == 0) {
            zeroesTotal++;
         }

         stepsTotal++;

         System.out.print(" " + position); 

     }
     System.out.println();
     System.out.println("The final position is: " + position);
     System.out.println("The number of steps taken is: " + stepsTotal);
     System.out.println("There are " + zeroesTotal + " zeroes." );
}