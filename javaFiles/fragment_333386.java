import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class NewJFrame2 extends javax.swing.JFrame {
   private static final String OVERLAID = "Overlaid!";
   boolean OptionsDrag = false, OptionsDrop = false;
   private Point initialLoc;
   private Point initialLocOnScreen;

   public NewJFrame2() {
      initComponents();
   }

   private void initComponents() {
      mobileLabel = new javax.swing.JLabel("Mobile");
      mobileLabel.setForeground(Color.white);
      fixedLabel = new javax.swing.JLabel("Fixed");
      notificationLabel = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setMaximumSize(new java.awt.Dimension(400, 300));
      setMinimumSize(new java.awt.Dimension(400, 300));
      getContentPane().setLayout(null);

      mobileLabel.setBackground(new java.awt.Color(0, 0, 255));
      mobileLabel.setOpaque(true);
      mobileLabel.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mousePressed(java.awt.event.MouseEvent evt) {
            jLabel1MousePressed(evt);
         }

         public void mouseReleased(java.awt.event.MouseEvent evt) {
            jLabel1MouseReleased(evt);
         }
      });
      mobileLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
         public void mouseDragged(java.awt.event.MouseEvent evt) {
            jLabel1MouseDragged(evt);
         }
      });
      getContentPane().add(mobileLabel);
      mobileLabel.setBounds(90, 130, 48, 48);

      fixedLabel.setBackground(new java.awt.Color(0, 255, 255));
      fixedLabel.setOpaque(true);
// !!     fixedLabel.addMouseListener(new java.awt.event.MouseAdapter() {
//         public void mouseEntered(java.awt.event.MouseEvent evt) {
//            jLabel2MouseEntered(evt);
//         }
//      });
      getContentPane().add(fixedLabel);
      fixedLabel.setBounds(230, 80, 48, 48);

      //!! notificationLabel.setText("showed");
      // !! notificationLabel.setVisible(false);
      getContentPane().add(notificationLabel);
      // notificationLabel.setBounds(40, 30, 37, 20); //!!
      notificationLabel.setLocation(40, 30);  //!! 
      notificationLabel.setSize(notificationLabel.getPreferredSize()); //!! 

      pack();
   }

   private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {
      Component comp = (Component) evt.getSource();
      initialLoc = comp.getLocation();
      initialLocOnScreen = evt.getLocationOnScreen();
   }

   private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {
      Component comp = (Component) evt.getSource();
      Point locOnScreen = evt.getLocationOnScreen();

      int x = locOnScreen.x - initialLocOnScreen.x + initialLoc.x;
      int y = locOnScreen.y - initialLocOnScreen.y + initialLoc.y;
      comp.setLocation(x, y);
      OptionsDrop = true;

      if (compIntersectsFixed(comp)) {

         // if you want to place the mobileLabel directly on top
         // of the fixedLabel
         comp.setLocation(fixedLabel.getLocation());
         repaint();
         notificationLabel.setText(OVERLAID);
         notificationLabel.setSize(notificationLabel.getPreferredSize());
      } else {
         notificationLabel.setText("");
      }
      revalidate();
      repaint();
   }

   private boolean compIntersectsFixed(Component comp) {
      Rectangle compRect = comp.getBounds();
      Rectangle fixedRect = fixedLabel.getBounds();
      if (compRect.intersects(fixedRect)) {
         return true;
      }
      return false;
   }

   private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {
      Component comp = (Component) evt.getSource();
      Point locOnScreen = evt.getLocationOnScreen();

      int x = locOnScreen.x - initialLocOnScreen.x + initialLoc.x;
      int y = locOnScreen.y - initialLocOnScreen.y + initialLoc.y;
      comp.setLocation(x, y);
      OptionsDrag = true;
   }

// !!  private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {
//      if (OptionsDrag == true && OptionsDrop == true) {
//         notificationLabel.setVisible(true);
//      }
//   }

   public static void main(String args[]) {

      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
               .getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(
               java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(
               java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(
               java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(
               java.util.logging.Level.SEVERE, null, ex);
      }

      java.awt.EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            new NewJFrame2().setVisible(true);
         }
      });
   }

   // !! name changes
   private javax.swing.JLabel mobileLabel;
   private javax.swing.JLabel fixedLabel;
   private javax.swing.JLabel notificationLabel;
}