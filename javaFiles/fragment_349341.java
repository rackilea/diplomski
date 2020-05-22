import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyTest {

    public static void main(String args[]) throws Exception {

        JFrame guiFrame = new JFrame("Test Frame");
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Example GUI");
        guiFrame.setSize(300, 250);
        guiFrame.setLocationRelativeTo(null);

        JButton btn = new JButton("Hit Me");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                guiFrame.dispose();
            }
        });
        guiFrame.add(btn, BorderLayout.SOUTH);
        guiFrame.setVisible(true);

    }
}