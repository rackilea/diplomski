public class ImageMerger {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedImage img1 = //some code here
        BufferedImage img2 = //some code here
        BufferedImage img3 = //some code here
        BufferedImage img4 = //some code here

        int mergeWidth = 20; // pixels to merge.
        BufferedImage merge =  ImageMerger.joinVertical(
                ImageMerger.joinHorizontal(img1, img2, mergeWidth),
                ImageMerger.joinHorizontal(img3, img4, mergeWidth),mergeWidth);

        //do whatever you want with merge. gets here in about 75 milliseconds

    }

    public static BufferedImage joinHorizontal(BufferedImage i1, BufferedImage i2, int mergeWidth){
        if (i1.getHeight() != i2.getHeight()) throw new IllegalArgumentException("Images i1 and i2 are not the same height");

        BufferedImage imgClone = new BufferedImage(mergeWidth, i2.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D cloneG = imgClone.createGraphics();
        cloneG.drawImage(i2, 0, 0, null);
        cloneG.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN, 0.5f));
        cloneG.drawImage(i2, 0, 0, null);

        BufferedImage result = new BufferedImage(i1.getWidth() + i2.getWidth() 
                - mergeWidth, i1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = result.createGraphics();
        g.drawImage(i1, 0, 0, null);
        g.drawImage(i2.getSubimage(mergeWidth, 0, i2.getWidth() - mergeWidth,
                i2.getHeight()), i1.getWidth(), 0, null);
        g.drawImage(imgClone, i1.getWidth() - mergeWidth, 0, null);

        return result;
    }
    public static BufferedImage joinVertical(BufferedImage i1, BufferedImage i2, int mergeWidth){
        if (i1.getWidth() != i2.getWidth()) throw new IllegalArgumentException("Images i1 and i2 are not the same width");

        BufferedImage imgClone = new BufferedImage(i2.getWidth(), mergeWidth, BufferedImage.TYPE_INT_ARGB);
        Graphics2D cloneG = imgClone.createGraphics();
        cloneG.drawImage(i2, 0, 0, null);
        cloneG.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN, 0.5f));
        cloneG.drawImage(i2, 0, 0, null);

        BufferedImage result = new BufferedImage(i1.getWidth(), 
                i1.getHeight() + i2.getHeight() - mergeWidth, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = result.createGraphics();
        g.drawImage(i1, 0, 0, null);
        g.drawImage(i2.getSubimage(0, mergeWidth, i2.getWidth(),
                i2.getHeight() - mergeWidth), 0, i1.getHeight(), null);
        g.drawImage(imgClone, 0, i1.getHeight() - mergeWidth, null);

        return result;
    }

}