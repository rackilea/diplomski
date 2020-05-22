class GameView {
    private Shape[] shapes;

    public GameView(Shape[] shapes) {
        this.shapes = shapes;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                g.setColor(Color.darkGray);
                g.fillRect(1,1,410,410);

                shapes[1].draw(g);
                shapes[2].draw(g);
            }
        }
    }
}

class MyKeyListener {
    private Shape[] shapes;

    public MyKeyListener(Shape[] shapes) {
        this.shapes = shapes;
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
           if(shapes[1].getX() >= 410) {
               shapes[1].setX(410);
           } else {
               moveRight();
           }
        }
    }
}