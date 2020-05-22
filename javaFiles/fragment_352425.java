private class RatingMouseListener extends MouseAdapter {
    private final int index;

    public RatingMouseListener(int index) {
        this.index = index;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered for rating " + index);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited for rating " + index);
    }
}