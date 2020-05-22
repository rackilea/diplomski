@Override
    public void paintComponent(Graphics g) {
        //background
        super.paintComponent(g);
        g.setColor(Color.decode("#666665"));
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(0, 0, 800, 600);
        g2d.drawImage(bg, 0, ...