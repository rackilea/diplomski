import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class CartEg extends JPanel {
   private static final long serialVersionUID = 1L;
   private static final int GAP = 10;
   private static final String TITLE_TEXT = "Some Great Title";
   private JTextArea itemArea = new JTextArea(25, 60);

   // create an Action that can be added to a JButton or a JMenuItem
   private Action disposeAction = new DisposeAction("Exit", KeyEvent.VK_X);
   private JMenuBar menuBar = new JMenuBar();  // menu bar for GUI

   public CartEg() {
      // create centered title JLabel
      JLabel titleLabel = new JLabel(TITLE_TEXT, SwingConstants.CENTER);
      // make it big and bold
      titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 42f));

      itemArea.setWrapStyleWord(true);
      itemArea.setLineWrap(true);
      JScrollPane scrollPane = new JScrollPane(itemArea);

      JPanel bottomButtonPanel = new JPanel(); // panel to hold JButtons
      bottomButtonPanel.setLayout(new BoxLayout(bottomButtonPanel, BoxLayout.LINE_AXIS));
      bottomButtonPanel.add(new JButton("Left Button"));
      bottomButtonPanel.add(Box.createHorizontalGlue());
      bottomButtonPanel.add(new JButton("Right Button 1"));
      bottomButtonPanel.add(new JButton("Right Button 2"));

      // create jbutton that uses our dispose Action
      bottomButtonPanel.add(new JButton(disposeAction));

      // create some empty space around our components
      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      // use a BorderLayout for the main JPanel
      setLayout(new BorderLayout(GAP, GAP));

      // add JScrollPane to the BorderLayout.CENTER position
      // add your JPanel that holds buttons to the BorderLayout.PAGE_END
      // and add your title JLabel to the BorderLayout.PAGE_START position

      add(scrollPane, BorderLayout.CENTER);
      add(titleLabel, BorderLayout.PAGE_START);
      add(bottomButtonPanel, BorderLayout.PAGE_END);

      // flesh out our jmenubar with a JMenu
      JMenu fileMenu = new JMenu("File");
      fileMenu.setMnemonic(KeyEvent.VK_F); // alt-F to invoke it

      // add a JMenuItem that uses the same disposeAction
      fileMenu.add(new JMenuItem(disposeAction));
      menuBar.add(fileMenu);
   }

   // expose the JMenuBar to the world
   public JMenuBar getMenuBar() {
      return menuBar;
   }

   private class DisposeAction extends AbstractAction {
      private static final long serialVersionUID = 1L;
      public DisposeAction(String name, int mnemonic) {
         super(name); // set button's text
         putValue(MNEMONIC_KEY, mnemonic); // set it's mnemonic key
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         // get the button that caused this action
         Object source = e.getSource();
         if (source instanceof AbstractButton) {
            AbstractButton exitButton = (AbstractButton) source;

            // get the parent top level window
            Window topWindow = SwingUtilities.getWindowAncestor(exitButton);
            if (topWindow == null) { // if null, then likely in a JMenuItem
               // so we have to get its jpopupmenu parent
               Container parent = exitButton.getParent();
               if (parent instanceof JPopupMenu) {
                  JPopupMenu popupMenu = (JPopupMenu) parent;

                  // get the invoker for the pop up menu
                  Component invoker = popupMenu.getInvoker();
                  if (invoker != null) {
                     // and get *its* top level window
                     topWindow = SwingUtilities.getWindowAncestor(invoker);
                  }
               }
            }
            if (topWindow != null) {
               // dispose of the top-level window
               topWindow.dispose();
            }
         }
      }
   }

   private static void createAndShowGui() {
      CartEg mainPanel = new CartEg();

      JFrame frame = new JFrame("Cart Example");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.setJMenuBar(mainPanel.getMenuBar());
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