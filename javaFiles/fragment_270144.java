public static int NA = ...;

private void drawData()
{
    bufferedImage = new BufferedImage(data.length,data[0].length, BufferedImage.TYPE_INT_ARGB);
    Graphics2D bufferedGraphics = bufferedImage.createGraphics();
    try {
        for (int x = 0; x < data.length; x++)
        {
            for (int y = 0; y < data[0].length; y++)
            {
                int colorIndex = dataColorIndices[x][y];
                if (colorIndex != NA) {
                    bufferedGraphics.setColor(colors[colorIndex]);
                    bufferedGraphics.fillRect(x, y, 1, 1);
                }
// Alternate flow, if you really want the pixels to be white
//                else {
//                    bufferedGraphics.setColor(Color.WHITE);
//                    bufferedGraphics.fillRect(x, y, 1, 1);
//                }
            }
        }
    }
    finally {
        bufferedGraphics.dispose();
    }
}