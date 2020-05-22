package tilegame.display;

import javax.swing.JFrame;

public class Display {
    private JFrame frame;
    private String title;
    private int width, height;
    public Display() {

    }
    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }
    public void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}