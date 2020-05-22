/**
   * Snappier multiple key detection using Primitive Collections Classes for Java http://pcj.sourceforge.net/
   * (standard Java Collection Objects can be used instead)
   * @author analogAI http://recursivepath.com/analogAI/
   */

   // usage:
   // if(this.checkKeysHeld(KeyEvent.VK_CONTROL) && this.checkKeysHeld(KeyEvent.VK_S)) println("CTRL+S");  

import bak.pcj.set.IntSet;
import bak.pcj.set.IntOpenHashSet;

public class HelloWorld extends PApplet {

  public IntSet keysheld = new IntOpenHashSet();
  /**
   * @param keycode key integer code, the value are constants defined in KeyEvent Class
   *                http://java.sun.com/j2se/1.4.2/docs/api/java/awt/event/KeyEvent.html
   *                e.g. KeyEvent.VK_A for letter A
   *                     KeyEvent.VK_0 for number 0
   *                     KeyEvent.VK_SHIFT for shift button
   * @return true if the key is currently held down, false otherwise
   */

  public boolean checkKeysHeld(int keycode){
    return this.keysheld.contains(keycode);
  }

  public void keyPressed(){
    // add key to the list of keys held down
    // with processing, the KeyEvent object is always available as "keyEvent",
    // the getKeyChar() is already in the variable 'key', and getKeyCode() is in the variable 'keyCode'.
    this.keysheld.add(this.keyEvent.getKeyCode());
    println("key pressed: "+KeyEvent.getKeyText(this.keyEvent.getKeyCode()));
    println("keys in current held list: "+this.keysheld.toString());
  }

  public void keyReleased(){
    // remove key from the list of keys held down
    this.keysheld.remove(this.keyEvent.getKeyCode());
  }
}