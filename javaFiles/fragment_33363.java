menuOne.add(new JMenuItem("1") {
    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        d.width = Math.max(d.width, 400); // set minimums
        d.height = Math.max(d.height, 300);
        return d;
    }
});