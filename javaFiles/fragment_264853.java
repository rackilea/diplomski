private void drawString(Graphics g, String text, int x, int y) {
    String[] splittedText = text.split("\n");
    for (int i = 0; i < splittedText.length; i++) {
        String line = splittedText[i];
        g.drawString(line, x, y + (g.getFontMetrics().getHeight() * i));
    }
}