import javax.swing.*;

public class SwingMvcTest {
   private static void createAndShowUI() {

      // create the model/view/control and connect them together
      MvcModel model = new MvcModel();
      MvcView view = new MvcView(model);
      MvcControl control = new MvcControl(model);
      view.setGuiControl(control);

      // EDIT: added menu capability
      McvMenu menu = new McvMenu(control);

      // create the GUI to display the view
      JFrame frame = new JFrame("MVC");
      frame.getContentPane().add(view.getMainPanel()); // add view here
      frame.setJMenuBar(menu.getMenuBar()); // edit: added menu capability
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   // call Swing code in a thread-safe manner per the tutorials
   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}