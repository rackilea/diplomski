import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


public class Test extends JFrame {
    private JTextArea txtTest;

    Test() {
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JScrollPane pane = new JScrollPane();
        txtTest = new JTextArea();
        pane.setViewportView(txtTest);
        this.add(pane, BorderLayout.CENTER);

        JButton btnAddText = new JButton("Add Text");
        btnAddText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTest.setText(txtTest.getText() + "\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi sagittis id nibh vel rhoncus. ");

                String text = txtTest.getText();

                txtTest.setCaretPosition(text != null ? text.length() : 0);
            }
        });
        this.add(btnAddText, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();             
            }
        });
    }
}