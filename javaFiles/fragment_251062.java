private JPanel createCPanel() {
    return new JPanel() {
        {
            setBackground(Color.BLUE);
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(150, 150);
        }
    };
}