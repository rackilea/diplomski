import javax.swing.event.EventListenerList;

public static class TestPanel extends JPanel implements KeyListener{  
    private JTextField text;
    private EventListenerList listenerList = new EventListenerList();

    TestPanel(){
        text = new JTextField();
        text.addKeyListener(this);
    }

    public void keyPressed(KeyEvent e){
        //doesn't create a new array, used for performance reasons 
        Object[] listeners = listenerList.getListenerList();
        //Array of pairs listeners[i] is Class, listeners[i + 1] is EventListener
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == KeyListener.class) {
                ((KeyListener)listeners[i+1]).keyPressed(e);
            }          
        }
    }

    public void addKeyListener(KeyListener l) {
        listenerList.add(KeyListener.class, l);
    }

    public void keyReleased(KeyEvent e){
      //idem as for keyPressed           
    }

    public void keyTyped(KeyEvent e){
      //idem as for keyPressed
    }
}