public int[][] getColors(final BufferedImage image){
    assert image != null;
    final int[][] colors = new int[image.getWidth()][image.getHeight()];
    for(int x = 0; x < colors.length; x++)
        for(int y = 0; y < colors[x].length; y++)
            colors[x][x] = image.getRGB(x, y);
    return colors;
}