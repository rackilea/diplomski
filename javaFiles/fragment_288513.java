import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class Game {
   public static Board board;

   public static void main(String[] args) {
      board = new Board();
   }
}

class Board implements ActionListener {
   public JFrame frame;
   public DrawBoard drawBoard;
   public Timer ticker = new Timer(20, this);

   public Board() {
      frame = new JFrame("Snake");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // frame.setPreferredSize(new Dimension(600, 720));
      frame.getContentPane().add(drawBoard = new DrawBoard(), BorderLayout.CENTER);
      frame.getContentPane().add(new BottomComponent(), BorderLayout.PAGE_END);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      ticker.start();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
   }
}

class DrawBoard extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = PREF_W;
   public static Color yellow = new Color(13816442);

   public DrawBoard() {
      setBorder(BorderFactory.createTitledBorder("Draw Board"));
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(yellow);
      g.fillRect(0, 120, 600, 600);
   }
}

class BottomComponent extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = 120;

   public BottomComponent() {
      setBorder(BorderFactory.createTitledBorder("Bottom Component"));
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }


}