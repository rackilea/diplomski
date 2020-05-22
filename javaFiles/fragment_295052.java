Class1{

   BlockingQueue queue = getMyList();
   Object element = queue.poll(0, TimeUnit.SECONDS);
   while(element != null) {
      //perform some actions, these actions may results in another thread being called
      //which will cause addToMyList() to be called while I'm still iterating over it
      //I want to keep iterating if an element gets added on the other thread  
      element = queue.poll(0, TimeUnit.SECONDS);
   }
}
Class2{
   BlockingQueue originalList = new LinkedBlockingQueue();

   public BlockingQueue getMyList()
     return originalList;

   void addToMyList(Element element)
     originalList.put(element);
}