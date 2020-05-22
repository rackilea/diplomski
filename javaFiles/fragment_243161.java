@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(myColor);
        g.fillRect(myX, myY, myWidth, myHeight); 
    }