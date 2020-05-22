public class Pizza {
     private boolean cheese;

     public synchronized /* added */ void setCheese(boolean cheese) {
         this.cheese = cheese;
     }

     public synchronized /* added */ boolean isCheese() {
         return cheese;
     }
}