import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Foo extends JFrame {

    public Foo() {
        setLayout(new BorderLayout());


JLabel background = new JLabel(new ImageIcon("Untitled.png"));
    add(background);
    background.setLayout(new FlowLayout());
    background.add(new JButton("foo"));
    setSize(500, 500);
    setVisible(true);
}

public static void main(String[] args) {
    Foo foo = new Foo();
}
}