//Face
g.setColor(Color.WHITE);
g.fillOval(120, 120, 170, 170);
int centerX = 120 + (170 / 2);
int arcHeight = 553;

//Hair
g.setColor(Color.BLACK);
drawHair(g, centerX, 25, 70, arcHeight);
drawHair(g, centerX, 25, 74, arcHeight);
// fill in the rest of your hair strands here
// I would make the width divisible by two for complete symmetry.