import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Date;

public class Foo implements ActionListener {

    JButton colorButton, labelButton;
    JLabel myLabel;
    JFrame frame;
    MyDrawPanel mdp;

    public static void main(String[] args) {
        Foo mcc = new Foo();
        mcc.createFrame();
    } //end of main

    public void createFrame() {
        frame = new JFrame();
        colorButton = new JButton("Changing Colors");
        labelButton = new JButton("Change Label");
        myLabel = new JLabel("I'm a label");
        mdp = new MyDrawPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        mdp.setPreferredSize(new Dimension(150, 150));
        jsp.setLeftComponent(mdp);
        frame.setBounds(10, 10, 600, 600);
        JPanel right = new JPanel();
        right.add(BorderLayout.SOUTH, colorButton);
        right.add(BorderLayout.EAST, labelButton);
        right.add(BorderLayout.WEST, myLabel);
        jsp.setRightComponent(right);
        frame.getContentPane().add(jsp);
        colorButton.addActionListener(this);
        labelButton.addActionListener(this);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorButton) {
            myLabel.setText("Color button's it");
            frame.repaint();
        } else {
            myLabel.setText("That's it" + new Date().toString());
        }

    }

    public class MyDrawPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            Color randomColor = new Color(red, green, blue);
            g.setColor(randomColor);
            g.fillOval(20, 70, 100, 100);
        }
    }
}