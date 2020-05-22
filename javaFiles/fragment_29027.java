public class ImageTile {
    public static void main(String[] args) throws IOException {
        Dimension tileDim = new Dimension(250, 250);
        BufferedImage image = ImageIO.read(new File(args[0]));

        Dimension imageDim = new Dimension(image.getWidth(), image.getHeight());

        for(int y = 0; y < imageDim.height; y += tileDim.height) {
            for(int x = 0; x < imageDim.width; x += tileDim.width) {

                int w = Math.min(x + tileDim.width,  imageDim.width)  - x;
                int h = Math.min(y + tileDim.height, imageDim.height) - y;

                BufferedImage tile = image.getSubimage(x, y, w, h);
                ImageIO.write(tile, "JPG", new File("tile-"+x+"-"+y+".jpg")); 
            }
        }
    }
}