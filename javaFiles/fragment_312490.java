protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
         for(int i = 0; i < dots.size(); i ++) {
             g2d.fillRect(dots.get(i).x, dots.get(i).y, 5, 5);
         }
    }