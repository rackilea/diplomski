public class sample extends Applet implements KeyListener {
String msg="";
@Override
public void init(){
    addKeyListener(this);
}
@Override
public void paint(Graphics g){
    g.drawString(msg,20,30);
}

public void keyTyped(KeyEvent e) {
    char key=e.getKeyChar();
    msg="KeyTyped : " + key;
    repaint();
 }
 ....
}