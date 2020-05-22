import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.*;

class Test {
    public static void main(String[] args) {
        new OutputPanel(null);
    }
}

class OutputPanel extends JFrame {

    public OutputPanel(Vector parsedOutput) {

        this.setTitle("Output");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel content = new JPanel(new GridLayout(0, 1));

        for (int i = 0; i < 100; i++) {    
            JLabel sectionLabel = new JLabel("hello " + i);
            content.add(sectionLabel);
        }
        JScrollPane scrollPane = new JScrollPane(content);

        this.add(scrollPane);
        this.pack();
        this.setVisible(true);

    }
}