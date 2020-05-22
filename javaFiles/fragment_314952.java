import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @see https://stackoverflow.com/a/17165034/230513
 */
public class DynamicTextboxes extends javax.swing.JFrame {

    /**
     * Creates new form DynamicTextboxes
     */
    public DynamicTextboxes() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel(new GridLayout(0, 1));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(createPanel());
        jTabbedPane1.addTab("tab1", jPanel1);
        add(jTabbedPane1);
        JPanel p = new JPanel();
        p.add(jButton1);
        add(p, BorderLayout.SOUTH);
        pack();
        setLocationByPlatform(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        jPanel1.add(createPanel());
        pack();
    }

    private JPanel createPanel() {
        JPanel p = new JPanel();
        JLabel lbl = new JLabel();
        lbl.setText("Label");
        p.add(lbl);
        JTextField txt = new JTextField(12);
        txt.setText("Text field");
        p.add(txt);
        return p;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DynamicTextboxes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration
}