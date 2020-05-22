import javax.swing.*;
import java.awt.*;

public class GuiStopwatch {


private static void stopwatch(JFrame frame) {

    JPanel panel = new JPanel();
    JButton Startbtn = new JButton("START");
    panel.add(Startbtn);
    frame.add(panel);

}


public static void main(String[] args) {
    JFrame frame = new JFrame("Stopwatch");

    stopwatch(frame);

    frame.setSize(600, 600);
    frame.setLayout(new FlowLayout());
    frame.setVisible(true);
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

}

}