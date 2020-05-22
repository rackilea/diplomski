static boolean isOpen = true;
static Object lock = new Object();
void main()
{
    ....
    add SomeHotKeyListener();
    ....
    synchronized(lock)
    {
        while(isOpen)
        {
            try {
                lock.wait()
            } catch(InterruptedException e) {
            }
        }
    }
    releaseResources();
}

void onHotKey(int hotKeyIdentifier)
{
    if(hotKeyIdentifier == something)
        do something;
    if(hotKeyIdentifier == something)
    {
        synchronized(lock)
        {
            isOpen = false;
            lock.notify();
        }
    }
}