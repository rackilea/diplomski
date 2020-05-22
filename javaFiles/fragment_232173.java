public class Test {

   private int number = 0;
   private static int counter = 0;
   public Test(){
       number = counter++;
   }

   public int getNumber() {
       return number; // each instance will have a unique value
   }

   public static int getCounter () {
       return counter; // this will return the current value of the counter
   }

}