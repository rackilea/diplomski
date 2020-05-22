public synchronized void returnFork() throws InterruptedException
{
    available = true;
    this.notifyAll();
}

public synchronized void takeFork() throws InterruptedException
{
    while(!available){
      this.wait();
    }
    available = false;
}