public class Seat{
   private String seatName;
   private boolean isTaken;

   public Seat(String s, boolean t){
      this.seatName = s;
      this.isTaken = t;
   }

   public boolean isSeatTaken(){
      return this.isTaken;
   }
}