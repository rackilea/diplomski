//what happens on the other threads
public void consumer()
{


   //keep this thread alive so long as there is data to process
   //or so long as there might be more data to process
   while (stillReadingData || !items.isEmpty())
   {
       //get the next item from the list
       //while the list is empty, we basically sleep for "timeout" timeunits,
       //then the while-loop would repeat, and so on
       Object o = items.poll(long timeout, int units);
       if (o != null) //process it
   }
}