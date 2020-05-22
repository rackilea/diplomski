import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Gui2 extends JFrame implements MouseListener {

   private static final long serialVersionUID = -973341728129968945L;
   JLayeredPane layeredPane;
   JPanel board;
   JLabel piece;
   int numSquares;
   private boolean currentPlayer;

   // !!
   private ImageIcon whiteIcon;
   private ImageIcon blackIcon;

   public Gui2() {
      // !!
      whiteIcon = createIcon(Color.white);
      blackIcon = createIcon(Color.black);

      Dimension boardSize = new Dimension(600, 600);

      numSquares = 6;
      currentPlayer = true;

      layeredPane = new JLayeredPane();
      getContentPane().add(layeredPane);
      layeredPane.setPreferredSize(boardSize);
      layeredPane.addMouseListener(this);

      board = new JPanel();
      layeredPane.add(board, JLayeredPane.DEFAULT_LAYER);

      board.setLayout(new GridLayout(numSquares, numSquares));
      board.setPreferredSize(boardSize);
      board.setBounds(0, 0, boardSize.width, boardSize.height);

      for (int i = 0; i < (numSquares * numSquares); i++) {
         // !! JPanel square = new JPanel(new BorderLayout());
         JPanel square = new JPanel(new GridBagLayout()); // !!

         square.setBorder(BorderFactory.createLineBorder(Color.black));
         square.setBackground(Color.green);
         square.setName(String.format("[%d, %d]", i % numSquares, i
               / numSquares)); // !!
         board.add(square);

      }

   }

   // !!
   private ImageIcon createIcon(Color color) {
      int width = 40;
      int height = width;
      BufferedImage img = new BufferedImage(width, height,
            BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = img.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(color);
      g2.fillOval(0, 0, width, height);
      g2.dispose();
      ImageIcon icon = new ImageIcon(img);
      return icon;
   }

   public static void main(String[] args) {
      JFrame frame = new Gui2();
      frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      frame.pack();
      frame.setResizable(true);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   @Override
   // !!
   public void mousePressed(MouseEvent e) {
      JPanel temp = (JPanel) board.findComponentAt(e.getX(), e.getY());
      System.out.println(e.getX() + " " + e.getY());
      System.out.println(temp.getName()); // !!

      if (currentPlayer) {
         // !! ImageIcon white = new ImageIcon("l/Images/white.jpg");
         // !! piece = new JLabel(white);
         piece = new JLabel(whiteIcon); // !!
         temp.add(piece);
      } else {
         // !! ImageIcon black = new ImageIcon("/Images/black.jpg");
         // !! piece = new JLabel(black);
         piece = new JLabel(blackIcon); // !!
         temp.add(piece);
      }
      temp.revalidate(); // !!
      temp.repaint(); // !!
      currentPlayer = !currentPlayer;

   }

   @Override
   public void mouseEntered(MouseEvent e) {

   }

   @Override
   public void mouseExited(MouseEvent arg0) {
   }

   @Override
   public void mouseClicked(MouseEvent arg0) {
   }

   @Override
   public void mouseReleased(MouseEvent e) {

   }

}