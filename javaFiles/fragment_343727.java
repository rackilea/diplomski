public class FrameData {
    BufferedImage img;
    Graphics2D g2; 
    // GET FRAME COUNT
    public int gf_count(int numFrames, BufferedImage[] frameArray, String fileLocation, String videoName) throws Exception, IOException {
        Java2DFrameConverter converter = new Java2DFrameConverter();
        int totFrames = 0;

        img = new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);
        g2 = img.createGraphics();

        FFmpegFrameGrabber grab = new FFmpegFrameGrabber(fileLocation + videoName);
        grab.start();
        for (int i = 0; i < numFrames; i++) {
            frameArray[i] = deepCopy(converter.convert(grab.grab()));
            totFrames = i;
        }
        for (int j = 0; j < totFrames; j++) {
            File outputfile = new File(fileLocation + "TImage" + j + ".jpg");
            ImageIO.write(frameArray[j], "jpg", outputfile);
        }
        return totFrames;
    }// END METHOD long getFrameCount()

    BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
    // This does what the converter.convert seems to do, which
    // is decode an image into the same place over and over.
    // if you don't copy the result every time, then you end up
    // with an array of references to the same last frame.
    BufferedImage draw() {
        g2.setColor(new Color(-1));
        g2.fillRect(0, 0, 100, 50);
        g2.setColor(new Color(0));
        g2.drawLine(0, 0, (int)(Math.random()*100.0), (int)(Math.random()*50.0));        
        return img;
    }

    public static void main(String... args) throws Exception, IOException {
        new FrameData().run();        
    }
    private void run() throws Exception, IOException {
        BufferedImage images[] = new BufferedImage[50];
        gf_count(50, images, "C:/Users/karl/Videos/", "dance.mpg");
    }
}