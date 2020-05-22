@Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.red);

        g.drawOval(x, y, 20, 20);

        ui.update(g, this);
    }