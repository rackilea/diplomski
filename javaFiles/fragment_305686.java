import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExcessiveSpacePanelTest {
    JFrame frame;
    JPanel panel;

    public void initGUI(){
        frame = new JFrame();
        panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 300);
            }
        };
        panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        System.out.println("panel size: [" + panel.getSize().width + "," + panel.getSize().height +"]");
        System.out.println("frame size: [" + frame.getSize().width + "," + frame.getSize().height+"]");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
            new ExcessiveSpacePanelTest().initGUI();
        });
    }
}