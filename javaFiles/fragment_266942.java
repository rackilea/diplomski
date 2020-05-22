class TileSet
{
    private Map<Integer, BufferedImage> tileImages;

    TileSet()
    {
        ....
        prepareTileImages();
    }

    private void prepareTileImages()
    {
        tileImages = new HashMap<Integer, BufferedImage>();

        for (int tile : allPossibleTileValuesThatMayBeInTheMap)
        {
            // These are the tiles that you originally rendered
            // in your "draw"-Method
            BufferedImage image = 
                getTileImage().getSubimage(
                    getTileX(tile), 
                    getTileY(tile),
                    getTileWidth(), 
                    getTileHeight());

            // Create a new, managed copy of the image,
            // and store it in the map
            BufferedImage managedImage = convertToARGB(image);
            tileImages.put(tile, managedImage);
        }
    }

    private static BufferedImage convertToARGB(BufferedImage image)
    {
        BufferedImage newImage = new BufferedImage(
            image.getWidth(), image.getHeight(),
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }    

    // This is the new method: For a given "tile" value
    // that you found at map[x][y], this returns the
    // appropriate tile:
    public BufferedImage getTileImage(int tile) 
    {
        return tileImages.get(tile);
    }
}