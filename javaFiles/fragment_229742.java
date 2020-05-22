@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Drawable dib;
    Iterator it;
    it = v.iterator();
    while (it.hasNext()) {
        dib = (Drawable) it.next();
        dib.draw(g);
    }
}