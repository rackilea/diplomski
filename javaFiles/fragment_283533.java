public void paint() {
    if (area != null && image != null) {
        g.clearRect(area.x, area.y, area.width, area.height);
        g.drawImage(image, 0, 0, null);
    }
    if (currentRect != null) {
        g.setColor(Color.RED);
        g.drawRect(rectToDraw.x, rectToDraw.y, rectToDraw.width, rectToDraw.height);
        g.setColor(new Color(255,255,255,150));
        g.fillRect(rectToDraw.x, rectToDraw.y, rectToDraw.width, rectToDraw.height);
    }
}

@Override
public void paint(Graphics gr) {
    if (buffer == null && area != null) {
        this.buffer = createImage(area.width, area.height);
        this.g = buffer.getGraphics();
    }
    paint();
    if (buffer != null)
        gr.drawImage(buffer, 0, 0, this);
}