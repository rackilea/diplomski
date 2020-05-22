import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameSize {

    private JFrame frm = new JFrame();
    private JPanel pnl = new JPanel();
    private JButton btn = new JButton("Get ScreenSize for JComponents");

    public FrameSize() {
        btn.setPreferredSize(new Dimension(400, 40));
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("JButton Size - " + btn.getSize());
                System.out.println("JPanel Size - " + pnl.getSize());
                System.out.println("JFrame Size - " + frm.getSize());
            }
        });
        pnl.setPreferredSize(new Dimension(640, 480));
        pnl.add(btn, BorderLayout.SOUTH);
        frm.add(pnl, BorderLayout.CENTER);
        frm.setLocation(150, 100);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EDIT
        frm.setResizable(false);
        frm.pack();
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                FrameSize fS = new FrameSize();
            }
        });
    }
}