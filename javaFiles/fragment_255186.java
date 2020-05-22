import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

public class Book_GUI extends JFrame {

    // private EconomyClass eco;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Book_GUI frame = new Book_GUI();
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
    public Book_GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridLayout(9, 5));
        // contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        // this.add(contentPane);
        JButton btnBookFlight;

        // eco = new EconomyClass();
        // eco.setSeats(5);
        for (int i = 0; i < 45; i++) {
            btnBookFlight = new JButton("Book" + i);
            btnBookFlight.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    JButton button = (JButton) arg0.getSource();
                    ;
                    button.setBackground(Color.RED);
                    button.setOpaque(true);
                }
            });
            // btnBookFlight.setBounds(77, 351, 100, 23);
            contentPane.add(btnBookFlight);
        }
        pack();
    }

}