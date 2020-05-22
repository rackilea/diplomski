private boolean isRunning;

public void gameLoop()
{
    while(isRunning) //the loop
    {
        doGameUpdates();
        render();
        Thread.sleep(1000); //the timing mechanism
    }
}