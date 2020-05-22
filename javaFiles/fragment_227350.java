import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Button extends JPanel {

    private JButton button;
    private Panel panel;

    public Button(Panel panel) {
        this.panel = panel;
        button = new JButton("BUTTON");
        add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clicked = (JButton) e.getSource();
                String input = clicked.getText();
                panel.setTextArea(input);
                //System.out.println(input);
            }
        });
    }
}

class Panel extends JPanel {

    private JTextArea textArea;

    public Panel() {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    void setTextArea(String text) {
        this.textArea.setText(text);
    }
}

public class Java extends JFrame {

    private Button dugme;
    private JFrame frame;
    private Panel panel;

    public Java() {
        frame = new JFrame();
        panel = new Panel();
        dugme = new Button(panel);
        //super("test");
        frame.setLayout(new BorderLayout());
        frame.setTitle("test");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(dugme, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Java app = new Java();
    }
}