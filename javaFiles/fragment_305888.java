private class Drawing extends JComponent {

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);//you would infact caluclate text size using FontMetrics#getStringWidth(String s)
    }
}