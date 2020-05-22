@Override
public void paint(Graphics g) {
    super.paint(g);

    for (int i = 0; letters != null && i < letters.length; i++) {
        text = String.valueOf(letters[i]);
        g.drawString(text, xCoordinates, yCoordinates);
        // xCoordinates += 10; remove this
        yCoordinates += 10;
    }
}