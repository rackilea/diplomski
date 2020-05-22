import java.awt.*;
import javax.swing.*;

public class BoxLayoutDemo {

    JButton button1 = new JButton("Button1");
    public BoxLayoutDemo() {
        JPanel pane = new JPanel(new GridLayout(1, 5));

        Box box = Box.createVerticalBox();
        box.add(new JButton("Button 1"));
        box.add(Box.createVerticalStrut(20));
        box.add(new JButton("Button 2"));
        box.add(Box.createVerticalStrut(20));
        box.add(new JButton("Button 3"));
        box.add(Box.createVerticalStrut(20));
        box.add(new JButton("Button 4"));
        box.add(Box.createVerticalStrut(20));
        box.add(new JButton("Button 5"));
        box.add(Box.createVerticalStrut(20));

        pane.add(new JPanel());
        pane.add(new JPanel());
        pane.add(box);
        pane.add(new JPanel());
        pane.add(new JPanel());

        JPanel pane2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pane2.add(new JButton("ButtonButton"));

        JFrame frame = new JFrame("GridBag Box");
        frame.add(pane, BorderLayout.CENTER);
        frame.add(pane2, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new BoxLayoutDemo();
            }
        });
    }
}