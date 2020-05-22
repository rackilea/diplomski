class VeryImportantCounterPrivate  {
   private int currentCount;
   public VeryImportantCounterPrivate(int initial_count)  {
      currentCount = initial_count;
   }
   public void incrementCount()  {
      currentCount++;
   }
   public int getCurrentCount()  {
      return  currentCount;
   }
}