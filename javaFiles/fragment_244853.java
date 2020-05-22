public class LoadCursor {

  public static void draw(BufferedImage image, int cursor,
      int diFlags) {
    int width = image.getWidth();
    int height = image.getHeight();

    User32 user32 = User32.INSTANCE;
    Gdi32 gdi32 = Gdi32.INSTANCE;

    Pointer hIcon = user32
        .LoadCursorW(Pointer.NULL, cursor);
    Pointer hdc = gdi32.CreateCompatibleDC(Pointer.NULL);
    Pointer bitmap = gdi32.CreateCompatibleBitmap(hdc,
        width, height);

    gdi32.SelectObject(hdc, bitmap);
    user32.DrawIconEx(hdc, 0, 0, hIcon, width, height, 0,
        Pointer.NULL, diFlags);

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < width; y++) {
        int rgb = gdi32.GetPixel(hdc, x, y);
        image.setRGB(x, y, rgb);
      }
    }

    gdi32.DeleteObject(bitmap);
    gdi32.DeleteDC(hdc);
  }

  public static void main(String[] args) {
    final int width = 128;
    final int height = 128;

    BufferedImage image = new BufferedImage(width, height,
        BufferedImage.TYPE_INT_ARGB);
    draw(image, User32.IDC_HAND, User32.DI_NORMAL);
    BufferedImage mask = new BufferedImage(width, height,
        BufferedImage.TYPE_INT_RGB);
    draw(mask, User32.IDC_HAND, User32.DI_MASK);
    applyMask(image, mask);

    JLabel icon = new JLabel();
    icon.setIcon(new ImageIcon(image));

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(icon);
    frame.pack();
    frame.setVisible(true);
  }

  private static void applyMask(BufferedImage image,
      BufferedImage mask) {
    int width = image.getWidth();
    int height = image.getHeight();
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        int masked = mask.getRGB(x, y);
        if ((masked & 0x00FFFFFF) == 0) {
          int rgb = image.getRGB(x, y);
          rgb = 0xFF000000 | rgb;
          image.setRGB(x, y, rgb);
        }
      }
    }
  }

}