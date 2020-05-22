public void mouseMoved(MouseEvent me) {
        Graphics g = getGraphics();
        mX = (int) me.getPoint().getX();
        mY = (int) me.getPoint().getY();
        update(g);
        //repaint();
    }