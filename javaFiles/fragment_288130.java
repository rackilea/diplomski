import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

public class TransparentBackground1 extends JFrame {
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JLabel lblBackground;

    public TransparentBackground1() {
        setPreferredSize(new Dimension(675, 375));
        jScrollPane = new JScrollPane();
        jTextArea = new JTextArea();
        lblBackground = new JLabel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane.setViewportView(jTextArea);

        //Code To make transparent
        jScrollPane.getViewport().setOpaque(false);
        jScrollPane.setOpaque(false);
        jTextArea.setOpaque(false);


        lblBackground.setIcon(new ImageIcon(getClass().getResource("/bg.png"))); // NOI18N

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransparentBackground().setVisible(true);
            }
        });
    }
}