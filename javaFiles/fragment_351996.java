import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TextLine extends JFrame {

    private JPanel contentPane;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TextLine frame = new TextLine();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TextLine() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLabel lblTextLineExample = new JLabel("Text Line Example");
        lblTextLineExample.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTextLineExample, BorderLayout.NORTH);

        JButton btnCancel = new JButton("Cancel");
        contentPane.add(btnCancel, BorderLayout.SOUTH);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        textArea.setRows(30);
        textArea.setColumns(50);
        TextLineNumber tln1 = new TextLineNumber(textArea);
        scrollPane.setRowHeaderView( tln1 );
        contentPane.add(scrollPane, BorderLayout.CENTER);
        pack();
    }

}