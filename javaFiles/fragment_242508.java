class ImageMouseListener extends MouseAdapter {

    private boolean isDragging = false;

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("clicked");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        if (isDragging) {
            System.out.println("released");
            JOptionPane.showMessageDialog(null, "I only want to be showed when \"drag\" event over but not for click event!");
        }
        isDragging = false
    }

    public void mouseDragged(MouseEvent e) {
        if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
            isDragging = true;
            System.out.println("dragged");
        }
    }
}