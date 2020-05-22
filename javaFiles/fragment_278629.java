import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BattleShipSwap {
   // make id's public
   public static final String MENU_ID = "menu";
   public static final String PLAY_ID = "play";

   private MainMenu mainMenu;
   private Play playMenu;

   private JFrame frame = new JFrame("Battleships");

   private CardLayout cl = new CardLayout();
   private JPanel contentPanel = new JPanel(cl);

   public BattleShipSwap() {
      initGui();
   }

   public void initGui() {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);

      mainMenu = new MainMenu(this);
      playMenu = new Play(this);

      contentPanel.add(mainMenu, MENU_ID);
      contentPanel.add(playMenu, PLAY_ID);

      frame.add(contentPanel, BorderLayout.CENTER);

      frame.pack();
      frame.setVisible(true);

   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new BattleShipSwap();
         }
      });
   }

   public void switchCard(String id) {
      // contentPanel.setLayout(new CardLayout());
      // CardLayout cardlayout = (CardLayout) contentPanel.getLayout();

      // why not just use the field?
      cl.show(contentPanel, id);
   }
}

class MainMenu extends JPanel {
   private BattleShipSwap battleShipSwap;

   public MainMenu(BattleShipSwap battleShipSwap) {
      setBorder(BorderFactory.createTitledBorder("Main Menu"));
      this.battleShipSwap = battleShipSwap;

      add(new JButton(new SwapButtonAction(battleShipSwap, BattleShipSwap.PLAY_ID)));
   }

}

class Play extends JPanel {
   private BattleShipSwap battleShipSwap;

   public Play(BattleShipSwap battleShipSwap) {
      setBorder(BorderFactory.createTitledBorder("Play Menu"));
      this.battleShipSwap = battleShipSwap;

      add(new JButton(new SwapButtonAction(battleShipSwap, BattleShipSwap.MENU_ID)));
   }
}

class SwapButtonAction extends AbstractAction {
   private BattleShipSwap battleShipSwap;
   private String id;

   public SwapButtonAction(BattleShipSwap battleShipSwap, String id) {
      super("Swap");
      putValue(MNEMONIC_KEY, KeyEvent.VK_S);
      this.battleShipSwap = battleShipSwap;
      this.id = id;
   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      battleShipSwap.switchCard(id);
   }
}