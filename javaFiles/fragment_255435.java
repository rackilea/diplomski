import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyButton extends JButton implements ActionListener {

    // private JButton button;
    private Color col1;
    private Color col2;
    private String text1;
    private String text2;

    public MyButton(Color col1, Color col2, String text1, String text2) {

        super(text1);   // *********** also add this **********

        this.col1 = col1;
        this.col2 = col2;
        this.text1 = text1;
        this.text2 = text2;
        // button = new JButton(text1);
        this.setOpaque(true);
        this.setBackground(col1);
        this.addActionListener(this);
    }

    public MyButton() {
        this(Color.blue, Color.red, "click = make red", "click = reset to blue");
    }

    public void ToggleState() {
        Color initialBackground = this.getBackground();

        if (initialBackground == col1) {
            this.setBackground(col2);
            this.setText(text2);
        } else if (initialBackground == col2) {
            this.setBackground(col1);
            this.setText(text1);
        }
    }

    public void actionPerformed(ActionEvent e) {
        // if (e.getSource() == button) {
        this.ToggleState();
        // }
    }
}