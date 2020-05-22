import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Example extends JFrame {
   public Example() {
      super();
      OuterView theGUI = new OuterView();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      add(theGUI);
      pack();
      setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new Example();
         }
      });
   }
}

class OuterView extends JPanel {
   private String innerValue = "";

   public OuterView() {
      super();
      InnerView innerPanel = new InnerView();
      innerPanel.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals(InnerView.COMBO_CHANGED)) {
               innerValue = evt.getNewValue().toString();
               System.out.println("new value from inside of OuterView: "
                     + innerValue);
            }
         }
      });
      JButton button = new JButton("display OuterView's model");
      button.addActionListener(new ButtonListener());
      add(innerPanel);
      add(button);
   }

   private class ButtonListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent ae) {
         System.out.println("button was clicked. innerValue: " + innerValue);
      }
   }
}

class InnerView extends JPanel {
   public static final String COMBO_CHANGED = "Combo Changed";
   // private SwingPropertyChangeSupport pcSupport = new
   // SwingPropertyChangeSupport(this);
   String oldValue = "";

   public InnerView() {
      super();
      String[] items = new String[] { "item 1", "item 2", "item 3" };
      JComboBox comboBox = new JComboBox(items);
      comboBox.addActionListener(new ComboBoxListener());
      add(comboBox);

   }

   private class ComboBoxListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent ae) {
         String text = ((JComboBox) ae.getSource()).getSelectedItem()
               .toString();
         firePropertyChange(COMBO_CHANGED, oldValue, text);
         oldValue = text;
         System.out.println("store " + text + " in InnerView's model");
      }
   }
}