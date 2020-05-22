game.addMouseMotionListener(new MouseAdapter() {
    @Override
    public void mouseMoved(MouseEvent e) {
        statusbar.setText(String.format("Your mouse is at %d, %d", e.getX(), e.getY()));
    }

    public void mouseExited(MouseEvent e){
        ifPaused = true;
    }   

    public void mouseEntered(MouseEvent e){
        ifPaused = false;
    }
});