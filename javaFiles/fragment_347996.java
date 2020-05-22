JPanel panel = new JPanel(new BorderLayout());
panel.add(new JLabel("A title"), BorderLayout.NORTH);
panel.add(new ChartPanel(chart) {
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}, BorderLayout.CENTER);