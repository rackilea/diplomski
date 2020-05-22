JLabel lblNewLabel = new JLabel("New label") {
// Maximum size should be larger than what the JMenuBar will ever be.
    @Override
    public Dimension getMaximumSize() {
        return new Dimension(Integer.MAX_VALUE, 1000);
    }
};