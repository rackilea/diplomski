public class MyFrame extends Frame implements AWTEventListener {

  ...

  public MyFrame(String title){
    super(title);
    ...
    this.getToolkit().addAWTEventListener(this, AWTEvent.KEY_EVENT_MASK);
  }

  @Override
  public void eventDispatched(AWTEvent event) {
    if(event instanceof KeyEvent){
      KeyEvent key = (KeyEvent)event;
      if(key.getID()==KeyEvent.KEY_PRESSED){ //Handle key presses
        System.out.println(key.getKeyChar());
        //TODO: do something with the key press
        key.consume();
      }
    }
  }
}