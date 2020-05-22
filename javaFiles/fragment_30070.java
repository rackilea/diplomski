class MyMouseAdaptor extends MouseAdapter implements MouseListener {
    AppWindow appWindow;

    public MyMouseAdaptor(AppWindow appWindow) {
        this.appWindow = appWindow;
    }

    public void mousePressed(MouseEvent e) {
        this.appWindow.MouseMsg = "Mouse Pressed at : " + e.getX() + ", "
            + e.getY();
        this.appWindow.locX = e.getX();
        this.appWindow.locY = e.getY();
        this.appWindow.repaint();
    }
}