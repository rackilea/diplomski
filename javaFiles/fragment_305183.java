private MouseAdapter wheelListener = new MouseAdapter() {
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        e.consume() // avoid the event to be triggred twice
        int notches = e.getWheelRotation();
        System.out.println(notches);
        while (notches > 0) {
            controller.zoomIn();
            notches--;
        }
        while (notches < 0) {
            controller.zoomOut();
            notches++;
        }
    }
};