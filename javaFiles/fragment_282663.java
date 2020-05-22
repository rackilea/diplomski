public static void drawString(Graphics g, String string, int x, int y,
        int seperation) {

    FontMetrics metrics = g.getFontMetrics();
    int drawx = x;

    for (int i = 0; i < string.length(); ++i) {
        String character = "" + string.charAt(i);

        g.drawString(character, drawx, y);
        drawx += seperation + metrics.stringWidth(character);
    }
}