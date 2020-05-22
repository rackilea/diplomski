public void run()
{
    running = true;
    while(running)
    {
        gameUpdate();
        gameRender();
        repaint();

        try
        {
            Thread.sleep(20);
        }
        catch(InterruptedException ex)
        {

        }
    } // <<< this is the missing brace
    System.exit(0);
}