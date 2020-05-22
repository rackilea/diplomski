MouseListener closer = new MouseAdapter() {

    @Override
    public void mouseExited(MouseEvent e) {
        Rectangle r = new Rectangle(sideBar.getSize());
        if (!r.contains(e.getPoint())) {
            sideBar.setVisible(false);
        }
    }

};