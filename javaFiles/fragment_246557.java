import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class ClassMain extends JFrame {

    private JLabel label;

    public static void main(String[] args) {
        new ClassMain();
    }

    public ClassMain() {
        super("This is my app");
        setSize(450,80);
        setLayout(new GridLayout(0,2));
        label = new JLabel("Hi");

        ClassEditor classEditor = new ClassEditor(this);

        add(label);
        add(classEditor.getButton());

        setVisible(true);
    }

    public void setLabel(String text) {
        label.setText(text);
    }

}