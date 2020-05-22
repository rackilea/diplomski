public void run()
{
        while (alive)
        {
            createNewCircle();
            updateGame();
            repaint();
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
}