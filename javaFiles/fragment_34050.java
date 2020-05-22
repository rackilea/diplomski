class MyFixedSizeDeque<T> extends ArrayDeque<T>
{
   private int maxSize;
   public MyDeque(int size)
   {
      this.maxSize = size; 
   }

   @Override
   public void addLast(T e)
   {
      this.addLast(e);
      if(this.size() > maxSize)
         this.removeFirst();
   } 
}