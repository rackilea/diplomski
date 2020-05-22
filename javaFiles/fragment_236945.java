import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Practice extends JFrame {

    JPanel main = new JPanel();
    JPanel gui = new JPanel();
    JButton btnadd = new JButton("Add Timer");

    public Practice() {

        main.setLayout(new BorderLayout());
        gui.setLayout(new FlowLayout());
        main.add(btnadd, BorderLayout.NORTH);
        main.add(gui, BorderLayout.CENTER);
        add(main);

        final Random rnd = new Random();
        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderPane orderPane = new OrderPane(rnd.nextInt(10));
                gui.add(orderPane);
                gui.revalidate();
                gui.repaint();
            }
        });

        main.add(gui);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                Practice p = new Practice();
                p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                p.setSize(800, 600);
                p.setLocationRelativeTo(null);
                p.setVisible(true);
            }
        });
    }
}