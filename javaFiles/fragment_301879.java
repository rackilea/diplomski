class BoardMouseListener extends MouseAdapter {

    @Override
    public void mouseEntered(MouseEvent e) {

        System.out.println(e.getX() + " - " + e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        System.out.println(e.getX() + " - " + e.getY());
    }
}