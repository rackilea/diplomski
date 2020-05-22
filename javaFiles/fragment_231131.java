import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class CusPanel extends JFrame implements ActionListener {
    private static final int COUNT = 5;

    private ArrayList<CustomPanel> aLCustomPanel = new ArrayList<>();
    private JPanel jp = new JPanel(new GridLayout(0, COUNT));

    public CusPanel() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        for (int i = 0; i < COUNT; i++) {
            aLCustomPanel.add(new CustomPanel(this));
            // here I could put the code from the 1 edit - see below
            jp.add(aLCustomPanel.get(i));
        }
        this.add(jp);
        pack();
        setLocationByPlatform(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source instanceof JButton) {
            JButton button = (JButton) source;
            Container parent = button.getParent();
            jp.remove(parent);
            jp.invalidate();
            jp.repaint();
            pack();
//            aLCustomPanel.remove(parent); <- optional
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CusPanel().setVisible(true);
            }
        });
    }
}

class CustomPanel extends JPanel {
    private JButton button;

    public CustomPanel(ActionListener parent) {
        button = new JButton("button");
        button.addActionListener(parent);
        this.add(button);
    }

    public JButton getButton() {
        return this.button;
    }
}