public int tileSize = 25;
public int y = 0; // y doesn't gets changed
public int x = 0;

g.setColor(Color.BLACK);
for(int row = 0; row < 650; row++) {
    g.drawRect(x, y, tileSize, tileSize);
    x += 25;
}
x = 0;