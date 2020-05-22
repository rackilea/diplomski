private Color[] colors = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.BLACK };
private int index = 0;
private Color color = Color.BLACK;

public void keyPressed(KeyEvent e) {

    // if correct key pressed:
    if(e.getKeyChar() == 'c') {
        color = colors[index]; // select appropriate color
        repaint();

        index++;
        index %= colors.length;  // set index to 0 if == length of array
     }
}

@Override
public void paint(Graphics g) {
    super.paint(g);   // *** don't forget me! ***
    g.setColor(color);
    // draw line with Color
    g.drawLine(x1, y1, x2, y2);
}