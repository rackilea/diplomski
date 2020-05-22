//panel.add(editMenu); 
panel.addMouseListener(new MouseAdapter(){
    public void mousePressed(MouseEvent e) {
        maybeShowPopup(e);
    }

    public void mouseReleased(MouseEvent e) {
        maybeShowPopup(e);
    }

    private void maybeShowPopup(MouseEvent e) {
        if (e.isPopupTrigger()) {
            editMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
});