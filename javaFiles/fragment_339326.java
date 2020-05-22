public class KeyEventWrapper
 {
     private KeyEvent keyEvent;

     public KeyEventWrapper(KeyEvent keyEvent)
      {
         this.keyEvent = keyEvent;
      }  

     public KeyEvent getKeyEvent()
      {
         return keyEvent;
      }

     public boolean equals(Object object)
      {
          if(object instanceof KeyEventWrapper)
            {
                KeyEventWrapper wrapper = (KeyEventWrapper) (object);
                KeyEvent k = wrapper.getKeyEvent();

                return (this.keyEvent.getKeyCode() == k.getKeyCode());
            } 
          return false;
      }

     public int hashCode()
       {
           return this.keyEvent.getKeyCode();
       }
 }