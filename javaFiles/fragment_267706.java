while(itr.hasNext())
{
     Object o = itr.next();

     try
     {
         if(o meets some condition)
            myList.remove(o);
     }
     catch(ConcurrentModificationException e)
     {
         //Whoops I abused my iterator. Do something else.
     }
}