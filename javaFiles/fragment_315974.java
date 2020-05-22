JPanel panel = new JPanel();

/* 
 * Get X coordinate of panel's origin relative to the parent's 
 * upper left corner measured in pixels. 
 */
panel.getX();

/* 
 * Get coordinates of mouse click relative to the source component.
 */
panel.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent event) {
        Point p = event.getPoint();
    }
});