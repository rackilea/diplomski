import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;
import javax.swing.text.*;

public class NewDemo extends JPanel {
   private static final long serialVersionUID = 1L;
   private JTextField textField, textField_1;

   private static void createAndShowGui() {
      NewDemo mainPanel = new NewDemo();

      JFrame frame = new JFrame("New Demo");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

   public NewDemo() {
      setLayout(new GridLayout(1, 0, 5, 5));
      setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      textField = new JTextField();
      textField.setColumns(10);
      add(textField);

      textField_1 = new JTextField();
      textField_1.setColumns(10);
      add(textField_1);

      MyDocumentFilter docFilter = new MyDocumentFilter(); // !!

      ((AbstractDocument) textField.getDocument()).setDocumentFilter(docFilter); // !!
      docFilter.addPropertyChangeListener(MyDocumentFilter.VALID,
            new PropertyChangeListener() {

               @Override
               public void propertyChange(PropertyChangeEvent evt) {
                  String text = ((Boolean) evt.getNewValue()) ? "Allowed"
                        : "Not Allowed";
                  textField_1.setText(text);
               }
            });
   }
}

class MyDocumentFilter extends DocumentFilter {
   public static final String VALID = "valid";
   private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(
         this);
   private boolean valid = true;

   @Override
   public void replace(FilterBypass fb, int i, int i1, String string,
         AttributeSet as) throws BadLocationException {    
      for (int n = string.length(); n > 0; n--) {
         char c = string.charAt(n - 1);
         System.out.println(c);
         if (Character.isAlphabetic(c)) {
            super.replace(fb, i, i1, String.valueOf(c), as);
            setValid(true);
         } else {
            setValid(false);
         }
      }
   }

   @Override
   public void remove(FilterBypass fb, int i, int i1)
         throws BadLocationException {
      super.remove(fb, i, i1);
   }

   @Override
   public void insertString(FilterBypass fb, int i, String string,
         AttributeSet as) throws BadLocationException {
      super.insertString(fb, i, string, as);
   }

   public boolean isValid() {
      return valid;
   }

   public void setValid(boolean valid) {
      boolean oldValue = this.valid;
      boolean newValue = valid;
      this.valid = valid;
      pcSupport.firePropertyChange(VALID, oldValue, newValue);
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }

   public void addPropertyChangeListener(String propertyName,
         PropertyChangeListener l) {
      pcSupport.addPropertyChangeListener(propertyName, l);
   }

   public void removePropertyChangeListener(String propertyName,
         PropertyChangeListener l) {
      pcSupport.removePropertyChangeListener(propertyName, l);
   }
}