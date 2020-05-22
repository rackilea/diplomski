import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class FooMouseListener extends JPanel {
   private GetImages getImages;

   public FooMouseListener() throws IOException {
      getImages = new GetImages();
      setLayout(new GridLayout(GetImages.SPRITE_ROWS, GetImages.SPRITE_COLS));
      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      for (int i = 0; i < GetImages.SPRITE_CELLS; i++) {
         JLabel label = new JLabel(getImages.getIcon(i));
         add(label);
         label.addMouseListener(myMouseAdapter);
      }
   }

   private class MyMouseAdapter extends MouseAdapter {
      @Override
      public void mousePressed(MouseEvent e) {
         JLabel label = (JLabel) e.getSource();
         Icon icon = label.getIcon();
         JOptionPane.showMessageDialog(label, icon, "Selected Icon", JOptionPane.PLAIN_MESSAGE);
      }
   }

   private static void createAndShowGui() {
      FooMouseListener mainPanel = null;
      try {
         mainPanel = new FooMouseListener();
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }

      JFrame frame = new JFrame("FooMouseListener");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class GetImages {
   private static final String SPRITE_PATH = "http://th02.deviantart.net/"
         + "fs70/PRE/i/2011/169/0/8/blue_player_sprite_sheet_by_resetado-d3j7zba.png";
   public static final int SPRITE_ROWS = 6;
   public static final int SPRITE_COLS = 6;
   public static final int SPRITE_CELLS = SPRITE_COLS * SPRITE_ROWS;

   private List<Icon> iconList = new ArrayList<>();

   public GetImages() throws IOException {
      URL imgUrl = new URL(SPRITE_PATH);
      BufferedImage mainImage = ImageIO.read(imgUrl);

      for (int i = 0; i < SPRITE_CELLS; i++) {
         int row = i / SPRITE_COLS;
         int col = i % SPRITE_COLS;
         int x = (int) (((double) mainImage.getWidth() * col) / SPRITE_COLS);
         int y = (int) ((double) (mainImage.getHeight() * row) / SPRITE_ROWS);
         int w = (int) ((double) mainImage.getWidth() / SPRITE_COLS);
         int h = (int) ((double) mainImage.getHeight() / SPRITE_ROWS);
         BufferedImage img = mainImage.getSubimage(x, y, w, h);
         ImageIcon icon = new ImageIcon(img);
         iconList.add(icon);
      }
   }

   // get the Icon from the List at index position
   public Icon getIcon(int index) {
      if (index < 0 || index >= iconList.size()) {
         throw new ArrayIndexOutOfBoundsException(index);
      }

      return iconList.get(index);
   }

   public int getIconListSize() {
      return iconList.size();
   }

}