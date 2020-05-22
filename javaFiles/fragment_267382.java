import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class JProgressBarWithJLabel {

    private JFrame frame = new JFrame("JLabel in JProgressBar");
    private JLabel label;
    private JProgressBar progressSeven;

    public JProgressBarWithJLabel() {
        progressSeven = new JProgressBar(0, 100){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 60);
            }
        };
        progressSeven.setValue(38);
        progressSeven.setLayout(new BorderLayout(5, 5));
        label = new JLabel();
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setBorder(new EmptyBorder(15, 15, 15, 15));
        label.setText("<html>I have already changed the JProgressBar's height "
                + "to be able to write the text on two lines but I don't want "
                + "to the change the width.</html>");
        progressSeven.add(label, BorderLayout.CENTER);
        frame.add(progressSeven);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(laf.getName())) {
                    UIManager.setLookAndFeel(laf.getClassName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JProgressBarWithJLabel();
            }
        });
    }
}