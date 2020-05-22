import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class MvcView {
   private MvcControl control;
   private JTextField stateField = new JTextField(10);
   private JPanel mainPanel = new JPanel(); // holds the main GUI and its components

   public MvcView(MvcModel model) {
      // add a property change listener to the model to listen and 
      // respond to changes in the model's state
      model.addPropertyChangeListener(new PropertyChangeListener() {
         public void propertyChange(PropertyChangeEvent evt) {
            // if the state change is the one we're interested in...
            if (evt.getPropertyName().equals(MvcModel.STATE_PROP_NAME)) {
               stateField.setText(evt.getNewValue().toString()); // show it in the GUI
            }
         }
      });
      JButton startButton = new JButton("Start");
      startButton.addActionListener(new ActionListener() {
         // all the buttons do is call methods of the control
         public void actionPerformed(ActionEvent e) {
            if (control != null) {
               control.startButtonActionPerformed(e); // e.g., here
            }
         }
      });
      JButton endButton = new JButton("End");
      endButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (control != null) {
               control.endButtonActionPerformed(e); // e.g., and here
            }
         }
      });

      // make our GUI pretty
      int gap = 10;
      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, gap, 0));
      buttonPanel.add(startButton);
      buttonPanel.add(endButton);

      JPanel statePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
      statePanel.add(new JLabel("State:"));
      statePanel.add(Box.createHorizontalStrut(gap));
      statePanel.add(stateField);

      mainPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
      mainPanel.setLayout(new BorderLayout(gap, gap));
      mainPanel.add(buttonPanel, BorderLayout.CENTER);
      mainPanel.add(statePanel, BorderLayout.PAGE_END);
   }

   // set the control for this view
   public void setGuiControl(MvcControl control) {
      this.control = control;
   }

   // get the main gui and its components for display
   public JComponent getMainPanel() {
      return mainPanel;
   }

}