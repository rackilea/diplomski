synchronized(lock) //acquires the lock
{
   ...
   do some work
   ...
   object.wait(); //releases the lock, and waits for a notification
}