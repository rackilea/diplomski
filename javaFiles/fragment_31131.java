import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

public class SortOfSimpleMvc {

   private static void createAndShowGui() {
      SimpleView view = new SimpleView();
      SimpleModel model = new SimpleModel();
      new SimpleControl(model, view);

      JFrame frame = new JFrame("SimpleMvc");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(view.getMainPanel());
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

class SimpleView {
   private JPanel mainPanel = new JPanel();
   private JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 5));
   private TextFieldView textFieldView = new TextFieldView();
   private LabelView labelView = new LabelView();

   public SimpleView() {
      JPanel topPanel = new JPanel();
      topPanel.add(textFieldView.getMainPanel());
      topPanel.add(labelView.getMainPanel());

      mainPanel.setLayout(new BorderLayout());
      mainPanel.add(topPanel, BorderLayout.PAGE_START);
      mainPanel.add(buttonPanel, BorderLayout.PAGE_END);

   }

   public JComponent getMainPanel() {
      return mainPanel;
   }

   public void setText(String text) {
      labelView.setLabelText(text);
   }

   public String getFieldText() {
      return textFieldView.getFieldText();
   }

   public void addAction(Action action) {
      buttonPanel.add(new JButton(action));

   }
}

class TextFieldView {
   private JTextField field = new JTextField(10);
   private JPanel mainPanel = new JPanel();

   public TextFieldView() {
      mainPanel.add(field);
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }

   public String getFieldText() {
      return field.getText();
   }
}

class LabelView {
   private JLabel label = new JLabel("Before");
   private JPanel mainPanel = new JPanel();

   public LabelView() {
      mainPanel.add(label);
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }

   public void setLabelText(String text) {
      label.setText(text);
   }
}

class SimpleModel {
   public static final String TEXT = "text";
   private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(
         this);
   private String text;

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }

   public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(propertyName, listener);
   }

   public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(propertyName, listener);
   }

   public String getText() {
      return text;
   }

   public void setText(String text) {
      String oldValue = this.text;
      String newValue = text;
      this.text = text;
      pcSupport.firePropertyChange(TEXT, oldValue, newValue);
   }

}

class SimpleControl {

   private SimpleModel model;
   private SimpleView view;

   public SimpleControl(SimpleModel model, SimpleView view) {
      this.model = model;
      this.view = view;

      model.addPropertyChangeListener(SimpleModel.TEXT, new ModelListener());

      view.addAction(new ChangeAction("Change Text", KeyEvent.VK_C));
      view.addAction(new RemoveAction("Remove Text", KeyEvent.VK_R));
   }

   private class ChangeAction extends AbstractAction {
      public ChangeAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         String text = view.getFieldText();
         model.setText(text);
      }
   }

   private class RemoveAction extends AbstractAction {
      public RemoveAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         model.setText("");
      }
   }

   private class ModelListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         view.setText(evt.getNewValue().toString());
      }
   }
}