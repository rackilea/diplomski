public static BufferedImage loadImage(String location)
{
    try {
        BufferedImage image = ImageIO.read(new File(location));
        return image;
    } catch (IOException e) {
        System.out.println("Could not load texture: " + location);
    }
    return null;
}