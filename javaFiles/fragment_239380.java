final Color newColor = ...
ScrollBarUI yourUI = new BasicScrollBarUI() {
    @Override
    protected JButton createDecreaseButton(int orientation) {
        JButton button = super.createDecreaseButton(orientation);
        button.setBackground(newColor);
        return button;
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        JButton button = super.createIncreaseButton(orientation);
        button.setBackground(newColor);
        return button;
    }
};
JScrollPane scroll = ...
scroll.getVerticalScrollBar().setUI(yourUI);
scroll.getHorizontalScrollBar().setUI(yourUI);