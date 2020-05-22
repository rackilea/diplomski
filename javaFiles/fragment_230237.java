import java.util.ArrayList;
import java.util.HashMap;

public class KeyThread extends Thread{
    private int sleep = 3;
    ArrayList<KeyActionListener> listener = new ArrayList<KeyActionListener>();
    IsKeyPressed isPressed = new IsKeyPressed();
    HashMap<KeyActionListener, Boolean> pressed = new HashMap<KeyActionListener, Boolean>();
    public KeyThread() {
        this.start();
    }
    public void run() {
        while (true){
            for (int i = 0; i < listener.size(); i++) {
                KeyActionListener curListener = listener.get(i);
                if (isPressed.isPressed(curListener.getKeyCode()) && !pressed.get(curListener)){
                    curListener.onKeyDown();
                    pressed.put(curListener, true);
                } else if(!isPressed.isPressed(curListener.getKeyCode()) && pressed.get(curListener)) {
                    curListener.onKeyUp();
                    pressed.put(curListener, false);
                } 

                if(isPressed.isPressed(curListener.getKeyCode())){
                    curListener.onKeyHolding();
                }
                try{
                    Thread.sleep(sleep);
                } catch(InterruptedException e){

                }
            }
        }
    }

    public void addKeyActionListener(KeyActionListener l){
        listener.add(l);
        pressed.put(l, false);
    }

}