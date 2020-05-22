for (RenderImage r : render.getList()){
    int x = r.getSize().getX();
    int y = r.getSize().getY();
    int wi = r.getSize().getWidth();
    int hi = r.getSize().getHeight();
    if (x + wi >= -1 && x + wi <= d.getWidth()){
        if (y + hi >= -1 && y + hi <= d.getHeight()){
            g.drawImage(r.getImage(), x, y, null);
        }
    }
}
frame.getContentPane().add(p);
frame.getContentPane().validate();
frame.getContentPane().repaint();