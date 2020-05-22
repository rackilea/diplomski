import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

@SuppressWarnings("serial")
public class SwappingLabel extends JPanel {
   public static final String IMG_PATH = "http://www.guitarchordsmagic.com/images/arrow.gif";
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private JLabel nextSymbolIcon = new JLabel("", SwingConstants.CENTER);
   private Icon nextIcon;

   public SwappingLabel() throws MalformedURLException {
      // Create our ImageIcon from online (or local) source
      nextIcon = getOnlineIcon(IMG_PATH);

      // add icon to JLabel
      nextSymbolIcon.setIcon(nextIcon);

      // set up key binding to recognize enter key press
      setupKeyBinding();

      // add the JLabel to the bottom of the GUI
      setBackground(Color.white);
      JPanel southPanel = new JPanel();
      southPanel.setOpaque(false);
      southPanel.add(nextSymbolIcon);
      setLayout(new BorderLayout());
      add(southPanel, BorderLayout.PAGE_END);
   }

   private Icon getOnlineIcon(String path) throws MalformedURLException {
      URL imgUrl = new URL(path);
      return new ImageIcon(imgUrl);
   }

   private void setupKeyBinding() {
      int condition = WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();
      KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

      // the action that will be called when enter is pressed
      Action action = new EnterAction();

      // bind the key press to the component to the action
      inputMap.put(enterKey, enterKey.toString());
      actionMap.put(enterKey.toString(), action);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class EnterAction extends AbstractAction {
      @Override
      public void actionPerformed(ActionEvent e) {
         nextSymbolIcon.setIcon(null);
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Blinking Label");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      try {
         frame.getContentPane().add(new SwappingLabel());
      } catch (MalformedURLException e) {
         e.printStackTrace();
         System.exit(-1);
      }
      frame.pack();
      frame.setLocationRelativeTo(null);
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