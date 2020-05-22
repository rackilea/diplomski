package ems;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame{
    private static final long serialVersionUID = 1L;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu window = new Menu();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Menu() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        this.setTitle("Menu");
        this.setBounds(100, 100, 450, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblLoginToThe = new JLabel("THE ELECTRICITY MONITORING SYSTEM");
        lblLoginToThe.setForeground(new Color(255, 255, 255));
        lblLoginToThe.setFont(new Font("Arial", Font.BOLD, 16));
        lblLoginToThe.setBounds(64, 22, 331, 16);
        this.getContentPane().add(lblLoginToThe);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(46, 139, 87));
        panel_1.setBounds(0, 0, 450, 63);
        this.getContentPane().add(panel_1);

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                Login login = new Login ();
                login.setVisible(true);
            }
        });
        btnLogout.setBounds(307, 222, 117, 29);
        this.getContentPane().add(btnLogout);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBounds(10, 222, 117, 29);
        this.getContentPane().add(btnExit);
    }
}