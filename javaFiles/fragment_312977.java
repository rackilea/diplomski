private int x1, x2;
    private int y1, y2;
    private View v;

    public void start()
    {
        for (int i = 0; i <= 250; i++)
        {
             v.invalidate();

             x2 += 1;

            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException e)
            {
            }
        }
    }