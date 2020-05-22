class VeryImportantCounterPublic  {
   public int currentCount;
   public VeryImportantCounterPublic(int initial_count)  {
      currentCount = initial_count;
   }
   public void incrementCount()  {
      currentCount++;
   }
   public int getCurrentCount()  {
      return  currentCount;
   }
}