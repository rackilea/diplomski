class DisplayJPanel extends javax.swing.JPanel {

   private TestObject to = null;

   public DisplayJPanel() {
      initComponents();
   }

   public TestObject getTo() {
      return to;
   }

   public void setTo(final TestObject to) {
      this.to = to;

      // add listener to listen and react to changes in to value's state
      to.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent evt) {
            if (TestObject.VALUE.equals(evt.getPropertyName())) {
               setLabel2Text(String.valueOf(to.getValue()));
            }
         }
      });
   }

   private void initComponents() {

      // etc...

   }

   public void setLabel2Text(String text) {
      jLabel2.setText(text);
   }

   private javax.swing.JLabel jLabel2;
   private javax.swing.JPanel jPanel1;
}

class TestObject {
   public static final String VALUE = "value";
   private int value = 0;
   private SwingPropertyChangeSupport propChangeSupport = new SwingPropertyChangeSupport(this);

   public int getValue() {
      return value;
   }

   public void setValue(int value) {
      int oldValue = this.value;
      int newValue = value;
      this.value = newValue;

      propChangeSupport.firePropertyChange(VALUE, oldValue, newValue);
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      propChangeSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      propChangeSupport.removePropertyChangeListener(listener);
   }

}