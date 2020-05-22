//start threads, pass them the queue


while(true)
{
    Throwable t;
    while((t = exceptionsToProcess.poll()) == null);
    //process t
}