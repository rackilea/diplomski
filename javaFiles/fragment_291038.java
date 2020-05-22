import java.awt.event.ActionEvent;

import javax.swing.*;

public class GuiTest2 {
   private static void createAndShowGui() {
      Gui2 mainPanel = new Gui2();

      JFrame frame = new JFrame("Gui2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
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

class Gui2 extends JPanel {
   private JTextField field = new JTextField(10);

   // pass a reference to the GUI object into the controller via
   // its constructor
   private JButton nextBtn = new JButton(new NextController(this, "Next"));

   public Gui2() {
      field.setEditable(false);
      field.setFocusable(false);

      add(field);
      add(nextBtn);
   }

   public void setTextFieldText(String text) {
      field.setText(text);
   }
}

class NextController extends AbstractAction {
   private static final String[] TEXTS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
   private Gui2 gui;
   private int index = 0;

   // pass the Gui2 object into the controller's constructor
   public NextController(Gui2 gui, String name) {
      super(name);
      this.gui = gui; // set the Gui2 field with the parameter
   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      // use the Gui2 object here
      gui.setTextFieldText(TEXTS[index]);
      index++;
      index %= TEXTS.length;
   }

}