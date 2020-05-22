public void setDimensions(int width) {
    setPreferredSize(null);
    Dimension d = getPreferredSize();
    setPreferredSize(new Dimension(width, d.height));
    setPopupWidth(d.width);
}