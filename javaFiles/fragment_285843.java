import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ssGUI extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    protected JButton b1, bConnect, bDisconnect, b2;
    protected JPanel canvas;

    public ssGUI() {
        setLayout(new BorderLayout());
        // run button
        b1 = new JButton("do something");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setMnemonic(KeyEvent.VK_D);
        b1.addActionListener(this);
        b1.setEnabled(false);
        // connect button
        bConnect = new JButton("Connect");
        bConnect.setMnemonic(KeyEvent.VK_E);
        bConnect.addActionListener(this);
        bConnect.setEnabled(true);
        // disconnect button
        bDisconnect = new JButton("Disconnect");
        bDisconnect.setMnemonic(KeyEvent.VK_E);
        bDisconnect.addActionListener(this);
        bDisconnect.setEnabled(false);
        // clean nmea data button
        b2 = new JButton("do something else");
        b2.setMnemonic(KeyEvent.VK_E);
        b2.addActionListener(this);
        b2.setEnabled(false);
        // drawing panel
        canvas = new JPanel();
        canvas.setBackground(Color.white);

        JPanel topPanel = new JPanel();
        topPanel.add(b1);
        topPanel.add(bConnect);
        topPanel.add(bDisconnect);
        topPanel.add(b2);
        add(topPanel, BorderLayout.NORTH);

        add(canvas, BorderLayout.CENTER);
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Range Adjustment GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ssGUI newContentPane = new ssGUI();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(500, 500);
        frame.setSize(500, 500);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}