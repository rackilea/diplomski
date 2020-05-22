public enum Status {
   STATUS_OPEN(0),  
   STATUS_STARTED(1),  
   STATUS_INPROGRESS(2),  
   STATUS_ONHOLD(3),  
   STATUS_COMPLETED(4),
   STATUS_CLOSED(5);

   private final int number;
   Status(int number) { 
       this.number = number;
   }

   public int getMagicNumber() { return number; } 
}