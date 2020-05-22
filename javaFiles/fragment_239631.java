@Override
protected void paintComponent(Graphics g)//what will paint each 20x20 square on the grid what it is assigned
{
    super.paintComponent(g);

    for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
            if (coords[x][y] == terrain[floor]) {
                g.setColor(new Color(46, 46, 46));
                g.fillRect((x * 20), (y * 20), 20, 20);
            } else ... {
                //...
            }
        }
    }

}