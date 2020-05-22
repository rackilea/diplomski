public void paint(Graphics g) {
    Graphics g2=im.getGraphics();
    g2.fillRect(_xPad, _yPad, 120, 10);
    for(int i = 0 ; i < 8 ; i++) {
        for(int j = 0 ; j < 10 ; j++) {
            g2.fillRect(_bricks[i][j].getX(), _bricks[i][j].getY() , 60, 20);
            }

    g.drawImage(im, 0, 0, this);
    }
}