int count = 0;
Set<Color> seenColors = new HashSet<>();
for (Ball ball : contents) {
    if (seenColors.add(ball.getColor())) {
        count++;
    }
}