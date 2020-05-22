public class ASD
{
  public static Image getImageFromArray(int[] pixels, int width, int height)
  {
    BufferedImage image =
        new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    WritableRaster raster = (WritableRaster) image.getData();
    raster.setPixels(0, 0, width, height, pixels);
    image.setData(raster);
    return image;
  }

  public static void main(String[] args) throws IOException
  {
    JFrame jf = new JFrame();
    JLabel jl = new JLabel();

    //3 bands in TYPE_INT_RGB
    int NUM_BANDS = 3;
    int[] arrayimage = new int[28 * 28 * NUM_BANDS];

    for (int i = 0; i < 28; i++)
    {
      for (int j = 0; j < 28; j++) {
        for (int band = 0; band < NUM_BANDS; band++)
          arrayimage[((i * 28) + j)*NUM_BANDS + band] = 255;
      }
    }
    ImageIcon ii = new ImageIcon(getImageFromArray(arrayimage, 28, 28));
    jl.setIcon(ii);
    jf.add(jl);
    jf.pack();
    jf.setVisible(true);
  }
}