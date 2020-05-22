public void paintComponent(java.awt.Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        Rectangle bar = new Rectangle(10,10,getWidth() - 20, getHeight() - 20 );
        g2.setColor(Color.GREEN);            
        g2.draw(bar);

    }