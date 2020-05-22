import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JPanel master = new JPanel(new BorderLayout());
                master.setBackground(Color.BLUE);

                JPanel gameInterface = new JPanel() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(400, 400);
                    }
                };
                gameInterface.setBackground(Color.MAGENTA);

                master.add(gameInterface);

                JPanel interactions = new JPanel(new BorderLayout());
                interactions.add(new JScrollPane(new JTextArea(5, 20)));

                JTextField field = new JTextField(15);
                JButton btn = new JButton("Button");

                JPanel message = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.weightx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                message.add(field, gbc);
                gbc.gridx = 1;
                gbc.weightx = 0;
                message.add(btn, gbc);

                interactions.add(message, BorderLayout.SOUTH);

                master.add(interactions, BorderLayout.SOUTH);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(master);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}