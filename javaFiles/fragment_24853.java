class Pauser
{
public:
    public synchronized void pause()
    {
         isPaused = true;
    }
    public synchronized void resume() 
    {
         isPaused = false;
         notifyAll();
    }
    public synchronized void waitIfPaused()
    {
         while(isPaused)
         {
             wait();
         }
    }
private:
    boolean isPaused;
};