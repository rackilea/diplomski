private class MyJTextPane extends JTextPane {
    public Dimension getPreferredSize() {
        return new Dimension(245,super.getPreferredSize().height);
    }
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }
}