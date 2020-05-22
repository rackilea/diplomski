in init():
currColor = colors[0];
bb.setColor(currColor);

public void render(){
    if (!iActive)
        bb.setColor(Color.white);
    bb.fillRect((int)p.x - 1, (int)p.y - 1, 3, 3);
    bb.setColor(Color.black);
    bb.fillRect((int)p.x, (int)p.y, 1, 1);
    bb.setColor(currColor);

    update(getGraphics());
}
private void toggleColour(int arg) {
    if (arg < colors.length) {
        currColor = colors[arg];
        bb.setColor(currColor);
    }
}