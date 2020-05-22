@Override
public void paintComponent(Graphics g) {
    int i = 0;
    loadLevel();

    for (int y = 0; y < Map.length; y++) {
        for (int x = 0; x < Map.length; x++) {
            new Tile(x, y).paintComponent(g);
            Map[y][x] = gameElements[i];
            g.drawString(Map[y][x], positionY, positionX);
            positionY = positionY + 50;
            System.out.print("[" + Map[y][x] + "]");
            i++;

        }

        positionY = 50;
        positionX = positionX + 50;
        System.out.println();
    }
}