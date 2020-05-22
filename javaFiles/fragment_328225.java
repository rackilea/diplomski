public class SomeOtherPanel extends JPanel {

     private PropertyChangeListener listener = new ValueListener();

      public PropertyChangeListener getListener(){
                  return listener;
      }

     private class ValueListener implements PropertyChangeListener{
            @Override
            public void propertyChange(PropertyChangeEvent evt){
                        if(evt == null)
                            return;

               if(evt.getPropertyName().equals("value") && ((int) evt.getNewValue()) == 1 ){
                    SomeOtherPanel.this.setVisible(true);
               }        
            }        
     }        
 }