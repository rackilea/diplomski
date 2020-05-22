public class Part4
{

   //This is the method you need to call
   public static double calculateAverage(int amount) {  
       Random rand = new Random();
       int total = 0;
       for (int i = 0; i < amount; i++) {
           total += rand.nextInt(101);
       }
       double avg = (double) total / amount;
       return avg;
   }

   public static void main(String args []) {
       //And this is how we call it
       double avgRes = calculateAverage(10)
       System.out.println("The average of 10 marks is " +avgRes);

   }
}