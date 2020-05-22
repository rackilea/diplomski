import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PlayingCardTest {


   public static void main(String[] args) {
      String pathToDeck = "http://www.jfitz.com/cards/classic-playing-cards.png";
      try {
         final List<ImageIcon> cardImgList = CreateCards.createCardIconList(pathToDeck);
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               JFrame frame = new JFrame("Moving Cards");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.add(new CardGameTable(cardImgList, frame));
               frame.pack();
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
            }
         });
      } catch (MalformedURLException e) {
         e.printStackTrace();
         System.exit(-1);
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }
   }
}

@SuppressWarnings("serial")
class CardGameTable extends JLayeredPane {

   private static final int PREF_W = 600;
   private static final int PREF_H = 400;
   private static final Color BASE_COLOR = new Color(0, 80, 0);
   private static final int CARD_COUNT = 20;
   private static final int WIDTH_SHOWING = 20;

   private JPanel basePane = new JPanel(null);

   public CardGameTable(List<ImageIcon> cardImgList, final JFrame frame) {
      basePane.setSize(getPreferredSize());
      basePane.setBackground(BASE_COLOR);
      add(basePane, JLayeredPane.DEFAULT_LAYER);

      final MyMouseAdapter myMouseAdapter = new MyMouseAdapter(this, basePane);
      addMouseListener(myMouseAdapter);
      addMouseMotionListener(myMouseAdapter);

      for (int i = 0; i < CARD_COUNT; i++) {
         JLabel card = new JLabel(cardImgList.remove(0));
         card.setSize(card.getPreferredSize());
         int x = (PREF_W / 2) + WIDTH_SHOWING * (CARD_COUNT - 2 * i) / 2 - 
               card.getPreferredSize().width / 2;
         int y = PREF_H - card.getPreferredSize().height - WIDTH_SHOWING * 2;
         card.setLocation(x, y);
         basePane.add(card);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

}

class MyMouseAdapter extends MouseAdapter {
   private JLabel selectedCard = null;
   private JLayeredPane cardGameTable = null;
   private JPanel basePane = null;
   private int deltaX = 0;
   private int deltaY = 0;

   public MyMouseAdapter(JLayeredPane gameTable, JPanel basePane) {
      this.cardGameTable = gameTable;
      this.basePane = basePane;
   }

   @Override
   public void mousePressed(MouseEvent mEvt) {
      Component comp = basePane.getComponentAt(mEvt.getPoint());
      if (comp != null && comp instanceof JLabel) {
         selectedCard = (JLabel) comp;
         basePane.remove(selectedCard);
         basePane.revalidate();
         basePane.repaint();

         cardGameTable.add(selectedCard, JLayeredPane.DRAG_LAYER);
         cardGameTable.revalidate();
         cardGameTable.repaint();
         deltaX = mEvt.getX() - selectedCard.getX();
         deltaY = mEvt.getY() - selectedCard.getY();
      }
   }

   @Override
   public void mouseReleased(MouseEvent mEvt) {
      if (selectedCard != null) {
         cardGameTable.remove(selectedCard);
         cardGameTable.revalidate();
         cardGameTable.repaint();

         basePane.add(selectedCard, 0);
         basePane.revalidate();
         basePane.repaint();
         selectedCard = null;
      }
   }

   @Override
   public void mouseDragged(MouseEvent mEvt) {
      if (selectedCard != null) {
         int x = mEvt.getX() - deltaX;
         int y = mEvt.getY() - deltaY;
         selectedCard.setLocation(x, y);
         cardGameTable.revalidate();
         cardGameTable.repaint();
      }
   }
}

class CreateCards {
   private static final int SUIT_COUNT = 4;
   private static final int RANK_COUNT = 13;

   public static List<ImageIcon> createCardIconList(String pathToDeck)
         throws MalformedURLException, IOException {
      BufferedImage fullDeckImg = ImageIO.read(new URL(pathToDeck));
      int width = fullDeckImg.getWidth();
      int height = fullDeckImg.getHeight();
      List<ImageIcon> iconList = new ArrayList<ImageIcon>();

      for (int suit = 0; suit < SUIT_COUNT; suit++) {
         for (int rank = 0; rank < RANK_COUNT; rank++) {
            int x = (rank * width) / RANK_COUNT;
            int y = (suit * height) / SUIT_COUNT;
            int w = width / RANK_COUNT;
            int h = height / SUIT_COUNT;
            BufferedImage cardImg = fullDeckImg.getSubimage(x, y, w, h);
            iconList.add(new ImageIcon(cardImg));
         }
      }
      Collections.shuffle(iconList);
      return iconList;
   }
}