// Determine the maximum vertical value...
int maxValue = 0;

for (Integer key : mapHistory.keySet()) {
    int value = mapHistory.get(key);
    maxValue = Math.max(maxValue, value);
}

int xPos = xOffset;

for (Integer key : mapHistory.keySet()) {
    int value = mapHistory.get(key);
    // Calculate the percentage that the given value uses compared to that of the
    // maximum value
    float percentage = (float)value / (float)maxValue;
    // Calculate the line height based on the available vertical space...
    int barHeight = Math.round(percentage * height);
    g2d.setColor(new Color(key, key, key));

    int yPos = height + yOffset - barHeight;
    Rectangle2D bar = new Rectangle2D.Float(xPos, yPos, barWidth, barHeight);

    g2d.fill(bar);
    g2d.setColor(Color.DARK_GRAY);
    g2d.draw(bar);

    xPos += barWidth;
}