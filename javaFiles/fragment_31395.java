g.setColor(Color.BLACK);
for (int i = 9; i < sequenceLength; i += 10) {
    String str = String.valueOf(i + 1);
    g.drawString(str,
            getCallboxBounds(i).getX()
                    + (getCallboxBounds(i).getWidth() - g.getFontMetrics().stringWidth(str)) / 2,
            g.getFontMetrics().getHeight());
}