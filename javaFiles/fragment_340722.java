public class Tuition {
   private int hour;
   private char major;
   private char status;

   public Tuition(Scanner kb) {
       // Initialize variables using methods that were initially static
       this.hour = this.getHours(kb); //Pass in the scanner, since you use it all over the place.
       ...
   }

   public static void main (String[] args) {
       Scanner kb = new Scanner(System.in);
       Tuition tuition = new Tuition();
       tuition.displayTuition();
   }

   public int getHours(Scanner kb) {
       // Do the processing you have written
   }
   // other methods for major and status

   public void displayTuition() {
       System.out.println("Credit Hours:" + this.hour);
       // etc
   }
   ...
}