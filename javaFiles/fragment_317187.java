JPanel glass = ((JPanel) giraffewindow.getGlassPane());
glass.setVisible(true);
glass.add(status);

glass.addMouseMotionListener(new MouseMotionListener() {

    @Override
    public void mouseMoved(MouseEvent evt) {
        status.setBounds(evt.getX(), evt.getY(), labelWidth,
                labelHeight);
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
    }
});