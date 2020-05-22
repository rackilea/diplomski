import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameTest {
    public static void main(String args[]) throws Exception {
        final JFrame frame = new JFrame();
        frame.setUndecorated(true);
        JButton button = new JButton("Minimize");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setState(Frame.ICONIFIED);
            }
        });
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}