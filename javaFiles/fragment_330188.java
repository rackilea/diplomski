JXTable table = new JXTable() {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Actual line thickness is: thickness * 2 + 1
        // Increase this as you wish.
        int thickness = 1;

        // Number of rows ABOVE the thick line
        int rowsAbove = 2;

        g.setColor(getGridColor());
        int y = getRowHeight() * rowsAbove - 1;
        g.fillRect(0, y - thickness, getWidth(), thickness * 2 + 1);
    };
};