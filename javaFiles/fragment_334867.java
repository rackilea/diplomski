JMapViewer map = new JMapViewer() {

    @Override
    public String getToolTipText(MouseEvent e) {
        Coordinate c = getPosition(e.getX(), e.getY());
        return c.getLat() + " " + c.getLon();
    }
};
map.setToolTipText(""); // initialize