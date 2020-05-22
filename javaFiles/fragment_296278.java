import java.awt.*;
import javax.swing.*;

public class Test {

    public void init() {
        final JPanel southPanel = new JPanel();
        FlowLayout layout = (FlowLayout)southPanel.getLayout();
        layout.setVgap(0);
        southPanel.setBackground(Color.BLUE);

        final JPanel innerPanel1 = new JPanel();
        innerPanel1.setBackground(Color.ORANGE);
        innerPanel1.add(new JLabel("Good"));

        final JPanel innerPanel2 = new JPanel();
        innerPanel2.setBackground(Color.RED);
        innerPanel2.add(new JLabel("Luck!"));

        final Box southBox = new Box(BoxLayout.LINE_AXIS);
        southBox.add(innerPanel1);
        southBox.add(innerPanel2);

        southPanel.add(southBox);   // <=== You're also missing this

        JFrame myFrame = new JFrame();
        JPanel center = new JPanel();
        center.setBackground(Color.yellow);
        myFrame.add(center);
        myFrame.add(southPanel, BorderLayout.SOUTH);
        myFrame.setSize(150, 100);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationByPlatform(true);
        myFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new Test().init();
            }
        });
    }
}