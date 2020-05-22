public void draw(Graphics2D g2) {

int xLeft = 0;
double barWidth = width / values.size();

for (int i = 0; i < values.size(); i++) {

    double barHeight = (values.get(i) / getMax()) * height;
    Rectangle bar = new Rectangle(xLeft, height - ((int) barHeight),
            (int) barWidth, (int) barHeight);

    red = generator.nextInt(255); 
    green = generator.nextInt(255);
    blue = generator.nextInt(255);
    randomColor = new Color(red, green, blue);

    g2.setColor(randomColor);
    g2.fill(bar);
    xLeft = (int) (xLeft + barWidth);
    xLeft++;

}