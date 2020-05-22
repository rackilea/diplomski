@Override
    public String getToolTipText(MouseEvent event) {
        String tooltip = super.getToolTipText(event);
        Point p = SwingUtilities.convertPoint(this, event.getPoint(), iconLabel);
        if (iconLabel.contains(p)) {
            tooltip = "I'm a banana";
        }
        return tooltip;
    }