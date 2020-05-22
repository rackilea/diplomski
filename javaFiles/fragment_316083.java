import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class MainForButtonPanel extends JPanel {
   public MainForButtonPanel() {
      setLayout(new GridLayout(4, 4));

      MouseAdapter myMA = new MouseAdapterMod();

      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            ButtonPanel btnPanel = new ButtonPanel();
            btnPanel.addMouseListener(myMA);
            add(btnPanel);
         }
      }

   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("MainForButtonPanel");
      frame.getContentPane().add(new MainForButtonPanel());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}

class ButtonPanel extends JPanel {

   private static final int TIMER_DELAY = 2000;
   private static final String JUST_CLICKED = "just clicked";
   private static final String WAITING_FOR_CLICK = "waiting for click";
   private static final Color CLICKED_COLOR = Color.pink;
   private JLabel label;

   public ButtonPanel() {
      label = new JLabel(WAITING_FOR_CLICK);
      add(label);
   }

   public void setButtonText() {
      label.setText(JUST_CLICKED);
      setBackground(CLICKED_COLOR);

      new Timer(TIMER_DELAY, new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            label.setText(WAITING_FOR_CLICK);
            setBackground(null);
            ((Timer)ae.getSource()).stop();
         }
      }).start();
   }

}

class MouseAdapterMod extends MouseAdapter {

   // usually better off with mousePressed rather than clicked
   public void mousePressed(MouseEvent e) {
       ButtonPanel btnPanel = (ButtonPanel)e.getSource();
       btnPanel.setButtonText();
   }
}