import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test3 {
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {

         @Override
         public void run() {
            GraphicsEnvironment ge = GraphicsEnvironment
                  .getLocalGraphicsEnvironment();
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            if (gs.isFullScreenSupported()) {
               SpaceInvaderUI spaceInvaderUI = new SpaceInvaderUI(gs.getDefaultConfiguration());
               gs.setFullScreenWindow(spaceInvaderUI);
            } else {
               JOptionPane.showMessageDialog(null,
                     "Does not support full screen!", "Error 0x01",
                     JOptionPane.ERROR_MESSAGE);
               System.exit(1);
            }
         }
      });
   }
}

// class SpaceInvaderUI extends JWindow {
class SpaceInvaderUI extends JFrame {

   private JPanel drawingPanel;
   private Image background;
   private JButton btnExit;

   public SpaceInvaderUI(GraphicsConfiguration gc) {
      super(gc);
      createWindow();
      addKeyBindings();
      setUndecorated(true);
   }

   private void addKeyBindings() {
      int condition = JPanel.WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = drawingPanel.getInputMap(condition );
      ActionMap actionMap = drawingPanel.getActionMap();

      boolean released = false;
      KeyStroke upArrowKeyStrokePressed = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, released );
      String upArrowPressed = "up arrow pressed";
      inputMap.put(upArrowKeyStrokePressed , upArrowPressed);
      actionMap.put(upArrowPressed, new AbstractAction() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.out.println("up arrow pressed");
         }
      });

      released = true;
      String upArrowReleased = "up arrow released";
      KeyStroke upArrowKeyStrokeReleased = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, released );
      inputMap.put(upArrowKeyStrokeReleased , upArrowReleased);
      actionMap.put(upArrowReleased , new AbstractAction() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.out.println("up arrow released");
         }
      });

   }

   private void createComponents() throws HeadlessException {
      drawingPanel = new DrawingPanel(background, this);
      btnExit = new JButton("Exit");
   }

   private void createWindow() {
      createComponents();
      addListeners();
      addComponentsToWindow();
   }

   private void addComponentsToWindow() {
      add(drawingPanel, BorderLayout.CENTER);
      add(btnExit, BorderLayout.SOUTH);
   }

   private void addListeners() {
//      KeyboardFocusManager manager = KeyboardFocusManager
//            .getCurrentKeyboardFocusManager();
//      manager.addKeyEventDispatcher(new MyDispatcher());
      btnExit.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent ae) {
            System.exit(0);
         }
      });
   }
//
//   private class MyDispatcher implements KeyEventDispatcher {
//
//      @Override
//      public boolean dispatchKeyEvent(KeyEvent e) {
//         System.out.println("in dispatch. KeyEvent := " + e);
//         if (e.getID() == KeyEvent.KEY_PRESSED) {
//            System.out.println("pressed");
//            System.exit(0);
//         } else if (e.getID() == KeyEvent.KEY_RELEASED) {
//            System.out.println("released");
//            System.exit(0);
//         } else if (e.getID() == KeyEvent.KEY_TYPED) {
//            System.out.println("Typed");
//            System.exit(0);
//         }
//         return false;
//      }
//   }
}

class DrawingPanel extends JPanel {

   private final Image background;
   private final SpaceInvaderUI invaderUI;

   DrawingPanel(Image background, SpaceInvaderUI invaderUI) {
      this.background = background;
      this.invaderUI = invaderUI;
      setBackground(Color.pink);
   }

   @Override
   protected void paintComponent(Graphics grphcs) {
      super.paintComponent(grphcs);
   }
}