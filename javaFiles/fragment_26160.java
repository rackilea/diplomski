list = new JList<String>(listOptions) {
    @Override
    public Dimension getPreferredScrollableViewportSize() {
        Dimension size = super.getPreferredScrollableViewportSize();
        size.width = 100;
        return size;
    }
};