import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MousLsnr extends JFrame implements ActionListener {
    public MousLsnr() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MenuPanel menuPanel = new MenuPanel();
        menuPanel.addActionListenerForButtons(this);
        add(menuPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actnEvnt) {
        System.out.println(actnEvnt.getSource());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new MousLsnr());
    }
}

class MenuPanel extends JPanel {
    private JButton button1;
    private JButton button2;

    public MenuPanel() {
        button1 = new JButton("One");
        button2 = new JButton("Two");
        add(button1);
        add(button2);
    }

    public void addActionListenerForButtons(ActionListener listener) {
        button1.addActionListener(listener);
        button2.addActionListener(listener);
    }
}