import java.awt.image.BufferedImage;
import java.awt.Color;

public class Test {
  public static char[][] imageToASCII(BufferedImage img) {
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
        double grayVal = 0.299*red + 0.587*green + 0.114*blue;

        if(grayVal >= 230) {
          res[j][i] = ' ';
        } else if(grayVal >= 200 && grayVal < 230) {
          res[j][i] = '.';
        } else if(grayVal >= 180 && grayVal < 200) {
          res[j][i] = '*';
        } else if(grayVal >= 160 && grayVal < 180) {
          res[j][i] = ':';
        } else if(grayVal >= 130 && grayVal < 160) {
          res[j][i] = 'o';
        } else if(grayVal >= 100 && grayVal < 130) {
          res[j][i] = '&';
        } else if(grayVal >= 70 && grayVal < 100) {
          res[j][i] = '8';
        } else if(grayVal >=50 && grayVal < 70) {
          res[j][i] = '#';
        } else {
          res[j][i] = '@';
        }
      }
    }
    return res;
  }
}