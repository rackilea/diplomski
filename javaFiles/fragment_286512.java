import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class a5Frame2 extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new a5Frame2();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public a5Frame2() {
        super("TV");
        setLocation(450, 75);
        setFocusable(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout()){

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }

        };
        JPanel panel = new JPanel();
        this.setLayout(new BorderLayout());

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel channelNumber = new JLabel("hello");
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.insets = new Insets(2, 0, 0, 2);
        panel.add(channelNumber, gc);

        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.add(panel, BorderLayout.NORTH);
        this.add(mainPanel);
        this.setVisible(true);

    }
}