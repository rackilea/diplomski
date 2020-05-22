public void paint(Graphics g) {
        super.paint(g); 
        if (pointStart != null) {  // *********
            g.setColor(Color.GREEN);
            g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
        }     
    }