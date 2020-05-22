addMouseMotionListener(new MouseAdapter() {

    int previousY;

    @Override
    public void mousePressed(MouseEvent e) {
        previousY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        int y = e.getY();
        if (y < previousY) {
            System.out.println("UP");
        } else if (y > previousY) {
            System.out.println("DOWN");
        }

        previousY = y;
    }
});