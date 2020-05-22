private static Clip clip;

...
public void keyReleased(KeyEvent e) {
    if (clip != null) {
        clip.stop();
    }
}
...

public void playSound(File soundName) {        
        ...
        clip = AudioSystem.getClip();            
        ...        
}