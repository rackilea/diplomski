public synchronized void P() throws InterruptedException 
{
    while (value == 0) 
    {
        wait();
    }
    value--;
}