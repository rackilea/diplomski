import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.SwingPropertyChangeSupport;

public class Main extends JFrame {

   public Main() {
      PropertyChangeView theGui = new PropertyChangeView();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(true);
      add(theGui);
      pack();
      setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new Main();
         }
      });
   }
}

class PropertyChangeView extends JPanel {
   private JButton button;
   private JTextField textfield;
   private GridBagConstraints gbc;
   private PropertyChangeController controller;

   public PropertyChangeView() {
      super(new GridBagLayout());
      PropertyChangeModel model = new PropertyChangeModel();
      controller = new PropertyChangeController(model);
      button = new JButton("Click me to increment the count");
      textfield = new JTextField(10);

      button.addActionListener(new ButtonListener());
      model.addPropertyChangeListener(new MyPropertyChangeListener());


      gbc = new GridBagConstraints();
      gbc.gridheight = 1;
      gbc.gridwidth = 1;
      gbc.anchor = GridBagConstraints.LINE_START;
      gbc.fill = GridBagConstraints.BOTH;

      gbc.gridx = 0;
      gbc.gridy = 0;
      add(button, gbc);

      gbc.gridx = 1;
      gbc.gridy = 0;
      add(textfield, gbc);
   }

   private class MyPropertyChangeListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         System.out.println("Event received " + evt);

         if (evt.getPropertyName().equals(PropertyChangeModel.CHANGED)) {
            textfield.setText(evt.getNewValue().toString());
         }
      }
   }

   private class ButtonListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         controller.setCounter(controller.getCounter() + 1);
         System.out.println("counter now = " + controller.getCounter());
      }
   }

}

class PropertyChangeController {
   private PropertyChangeModel model;

   // public PropertyChangeController() {
   // model = new PropertyChangeModel();
   // }


   public PropertyChangeController(PropertyChangeModel model) {
      this.model = model;
   }

   public int getCounter() {
      return model.getCounter();
   }


   public void setCounter(int i) {
      model.setCounter(i);
   }
}

class PropertyChangeModel {
   public static final String CHANGED = "property change model updated";

   private int counter;
   private SwingPropertyChangeSupport pcs;

   public PropertyChangeModel() {
      counter = 0;
      pcs = new SwingPropertyChangeSupport(this);
   }

   public void addPropertyChangeListener(
         PropertyChangeListener l) {
      pcs.addPropertyChangeListener(l);
   }

   public int getCounter() {
      return counter;
   }

   public void setCounter(int i) {
      int oldValue = counter;
      int newValue = i;
      counter = newValue;
      pcs.firePropertyChange(CHANGED, oldValue, newValue);
      System.out.println("setCounter finished with oldValue=" + oldValue
            + ", newValue=" + newValue);
   }
}