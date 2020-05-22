package Frame;

import javax.swing.JFrame;

class FrameApp extends JFrame{
public FrameApp(String name){
super(name);
}
} 


public class App {


 public static void main(String[] args) {

    FrameApp frame = new FrameApp("FirstFrame");
    frame.setTitle("MFF");
    frame.setSize(300, 700);
    frame.setVisible(true);

 }  

}