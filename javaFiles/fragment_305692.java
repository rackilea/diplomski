public class ImageLoader {

    public BufferedImage load(String path){
        try {
            return ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}