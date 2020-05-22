private class CustomTableUI extends BasicTableUI {

    @Override
    public void paint(Graphics g, JComponent c) {
        // Store defaults
        Color dropLineColor = UIManager.getColor("Table.dropLineColor");
        Color dropLineShortColor = UIManager.getColor("Table.dropLineShortColor");

        // Set your custom colors here
        UIManager.put("Table.dropLineColor", Color.cyan);
        UIManager.put("Table.dropLineShortColor", Color.cyan);

        // Allow the table to be painted
        super.paint(g, c);

        // Restore the defaults
        UIManager.put("Table.dropLineColor", dropLineColor);
        UIManager.put("Table.dropLineShortColor", dropLineShortColor);
    }

}