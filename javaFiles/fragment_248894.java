import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;

public class TicTacToeApp {
   public static void main(String[] args) {
      TicTacToeGame game;
      int size, need, player = 1;
      String[] names = new String[2];
      Scanner kbd = new Scanner(System.in);

      // TODO: uncomment in running code
      // System.out.print("Enter Player 1's name:  ");
      // names[0] = kbd.nextLine();
      // System.out.print("Enter Player 2's name:  ");
      // names[1] = kbd.nextLine();
      //
      // System.out.print("Enter the TIC-TAC-TOE grid size:  ");
      // size = kbd.nextInt();
      // System.out.print("Enter how many in a row you need to win:  ");
      // need = kbd.nextInt();
      // System.out.println();

      // TODO: For test purposes only. Delete in running code
      size = 3;
      need = 3;
      names[0] = "Foo";
      names[1] = "Bar";

      game = new TicTacToeGame(size, need, names);

      while (!game.haveWinner() && !game.isFull()) {
         player = (player + 1) % 2;
         try {
            game.playOneTurn(player);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         System.out.println("While loop looped");
      }

      if (game.haveWinner())
         System.out.println(names[player] + " is the winner!");
      else
         System.out.println("It's a TIE!");

      System.out.println("\nBye!");

   }
}

@SuppressWarnings("serial")
class TicTacToeGame extends JPanel {
   private static final Object LOCK = new Object();
   private volatile int player = 0;
   private int size;
   private int need;
   private String[] names;
   private JLabel nameLabel = new JLabel();
   // private JButton testButton = new JButton();
   private JButton[][] buttonGrid;
   private volatile boolean waiting = false;

   public TicTacToeGame(int size, int need, String[] names) {
      this.size = size;
      this.need = need;
      this.names = names;

      nameLabel.setText(names[0]);

      JPanel topPanel = new JPanel();
      topPanel.add(new JLabel("Player:"));
      topPanel.add(nameLabel);

      buttonGrid = new JButton[size][size];
      ButtonListener actionListener = new ButtonListener(this);
      JPanel middlePanel = new JPanel(new GridLayout(size, size));
      for (int row = 0; row < size; row++) {
         for (int col = 0; col < size; col++) {
            JButton button = new JButton("   ");
            middlePanel.add(button);
            buttonGrid[row][col] = button;
            button.addActionListener(actionListener);
         }
      }

      setLayout(new BorderLayout());
      add(topPanel, BorderLayout.NORTH);
      add(middlePanel, BorderLayout.CENTER);

      // run GUI on Swing event thread
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            JFrame frame = new JFrame("Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(TicTacToeGame.this);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
         }
      });
   }

   public int getPlayer() {
      return player;
   }

   public synchronized void playOneTurn(final int player)
         throws InterruptedException {
      this.player = player;
      System.out.printf("Player %d before wait%n", player);
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            nameLabel.setText(names[player]);
         }
      });
      synchronized (LOCK) {
         waiting = true;
         while (waiting) {
            LOCK.wait();
         }
      }
   }

   public boolean isFull() {
      for (int row = 0; row < size; row++) {
         for (int col = 0; col < size; col++) {
            if (buttonGrid[row][col].isEnabled()) {
               return false;
            }
         }
      }
      return true;
   }

   public boolean haveWinner() {
      // TODO finish this
      return false;
   }

   public void doNotification() {
      new Thread(new Runnable() {
         public void run() {
            synchronized (LOCK) {
               waiting = false;
               LOCK.notifyAll();
            }
         }
      }).start();
   }

   public void tttButtonPressed(ActionEvent e) {
      AbstractButton source = (AbstractButton) e.getSource();
      for (int r = 0; r < size; r++) {
         for (int c = 0; c < size; c++) {
            if (buttonGrid[r][c] == source) {
               String text = player == 0 ? "X" : "0";
               source.setText(text);
               source.setEnabled(false);
            }
         }
      }
      doNotification();
   }

}

class ButtonListener implements ActionListener {
   private TicTacToeGame ticTacToeGame;

   public ButtonListener(TicTacToeGame ticTacToeGame) {
      this.ticTacToeGame = ticTacToeGame;
   }

   public void actionPerformed(ActionEvent e) {
      ticTacToeGame.tttButtonPressed(e);
   };
}