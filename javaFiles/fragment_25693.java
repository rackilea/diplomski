//the collection with the stuff in it
static BlockingQueue<Object> items = new BlockingQueue<Object>();
//(there are a few different types of blocking queues, check javadocs.
//you would want Linked or Array blocking queue

//what happens on the reader thread
public void producer()
{
    //read the data into the collection
    for (all the data in the file)
    {
       //add the next item
       items.put(/* next item from file or w/e */);

       //stop if necessary
       if (atEndOfFile) stillReadingData = false;

       //etc
    }
}