import java.awt.image.BufferedImage;
import java.awt.Color;

public class Test {
  private static char[] map;

  private static void initMap() {
    map = new char[256];
    int[][] ranges = new int[][] {
      {0, 50}, {50, 70}, {70, 100}, {100, 130},
      {130, 160}, {160, 180}, {180, 200},
      {200, 230}, {230, 256}
    };
    char[] v = {' ', '#', '8', '&', 'o', ':', '*', '.', ' '};
    for(int i=0; i<v.length; i++) {
      for(int j=ranges[i][0]; j < ranges[i][1]; j++) {
        map[j] = v[i];
      }
    }
  }

  public static char[][] imageToASCII(BufferedImage img) {
    if (map == null) {
      initMap();
    }
    int w = img.getWidth();
    int h = img.getHeight();
    char[][] res = new char[h][w];

    for(int j=0; j<h; j++) {
      for(int i=0; i<w; i++) {
        int values = img.getRGB(i,j);
        Color oldColor = new Color(values);
        int red = oldColor.getRed();        // get red value
        int green = oldColor.getGreen();    // get green value
        int blue = oldColor.getBlue();
        int grayVal = (int)(0.299*red + 0.587*green + 0.114*blue);
        if (grayVal > 255) {
          grayVal = 255;
         }
        res[j][i] = map[grayVal];
      }
    }
    return res;
  }
}