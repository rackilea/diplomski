package mainpackage.display;
import java.awt.Canvas;    

import java.awt.Component;
import java.awt.Dimension;    

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;    

import static mainpackage.display.ButtonManager.*;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        frame.add(canvas);

        JPanel panel = new JPanel();
        //You can add many buttons as you need
        putButton(panel, getJButton("Button 1"), 100, 200);
        putButton(panel, getJButton("Button 2"), 800, 800);

        frame.setContentPane(panel);

        frame.pack();
    }

    public void postCreate(Component a) {
        frame.add(a);
    }
    public void postCreate(JButton j) {
        frame.add(j);
    }
    public Canvas getCanvas() {
        return canvas;
    }
    public JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        Display display = new Display("Hello", 1000, 1000);
    }
}