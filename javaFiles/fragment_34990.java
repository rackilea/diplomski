import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestFrame extends JFrame {

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx=0;
        c.gridy=0;

        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        add(getLbl(),c);


        JPanel left = new JPanel(new GridLayout(3,3,5,5));
        for(int i =0;i<9;i++){
            left.add(getLbl());
        }

        JPanel right = new JPanel(new GridLayout(3,2,5,5));
        for(int i =0;i<6;i++){
            right.add(getLbl());
        }

        c.weightx = 0;
        c.gridwidth = 1;
        c.gridy++;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.WEST;
        add(left,c);

        c.anchor = GridBagConstraints.EAST;
        c.gridx++;
        add(right,c);
    }


    private JLabel getLbl() {
        JLabel l = new JLabel("   ");
        l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return l;
    }

    public static void main(String args[]) {
        new TestFrame();
    }

}