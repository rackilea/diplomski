public void startAnimation()
{
    //Timer timer = new Timer(75, this);
    //timer.start();

    Timer timer = new Timer(1000, new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            move();
            repaint();
        }
    });
    timer.start();

    Timer timer2 = new Timer(3000, new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            addBalls(1);
        }
    });
    timer2.start();
}