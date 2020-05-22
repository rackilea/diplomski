class PqIter implements Iterator<T>
{
   final PriorityQueue<T> pq;
   public PqIter(PriorityQueue <T> source)
   {
     pq = new PriorityQueue(source); 
   }

   @Override
   public boolean hasNext()
   {
     return pq.peek() != null
   }

   @Override
   public T next()
   { return pq.poll(); }

   @Override
   public void remove()
   { throw new UnsupportedOperationException(""); }
}