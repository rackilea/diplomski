import javax.swing.*;

import java.awt.*;

public class app extends JFrame {

    public static void main(String[] args) {
        new app();
    }

    public app() {
        this.setSize(400, 400);
        this.setLocation(0, 0);
        this.setResizable(false);
        this.setTitle("Application");
        JPanel painel = new JPanel(null);
        // Creating the Input
        JTextField tf1 = new JTextField("Some random text", 15);
        tf1.setBounds(5, 5, this.getWidth() - 120, 20);
        tf1.setColumns(10);
        tf1.setText("Omg");

        // resultsTA,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        painel.add(tf1);
        // Creating the button
        JButton button1 = new JButton("Send");
        button1.setBounds(290, 5, 100, 19);
        painel.add(button1);
        // Creating the TextArea
        JTextArea ta1 = new JTextArea(15, 20);
        JScrollPane scr = new JScrollPane(ta1,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);// Add your text area to scroll pane 
        ta1.setBounds(5, 35, 385, 330);
        ta1.setLineWrap(true);
        ta1.setWrapStyleWord(true);
        scr.setBounds(20, 30, 100, 40);// You have to set bounds for all the controls and containers incas eof null layout
        painel.add(scr);// Add you scroll pane to container
        this.add(painel);
        this.setVisible(true);
    }
}