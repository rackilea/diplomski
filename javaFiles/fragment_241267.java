int count = 0;
Color lastColor = null;
for (Ball ball : contents) {
    Color nextColor = ball.getColor();
    if (!nextColor.equals(lastColor)) {
        count++;
        lastColor = nextColor;
    }
}