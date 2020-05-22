import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Runner {

    private final JFrame frame;

    private final JPanel home;
    private final JPanel second;

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.show();
    }

    public Runner() {
        this.frame = new JFrame();
        this.frame.setSize(new Dimension(500, 500));
        this.frame.setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel(new CardLayout());
        frame.setContentPane(contentPanel);

        home = buildMainPanel();
        second = buildSecondPanel();

        contentPanel.add("home", home);
        contentPanel.add("second", second);

    }

    public JPanel buildMainPanel() {
        JPanel something = new JPanel(null);
        something.setBounds(0,0,500,500);
        something.setBackground(Color.black);

        JButton flipButton = new JButton("Second");
        flipButton.setBounds(0,0,100,80);
        flipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) frame.getContentPane().getLayout();
                layout.show(frame.getContentPane(), "second");
            }
        });

        something.add(flipButton);
        return something;
    }

    public JPanel buildSecondPanel() {
        JPanel something = new JPanel(null);
        something.setBounds(0,0,500,500);
        something.setBackground(Color.blue);

        JButton flipButton = new JButton("Second");
        flipButton.setBounds(0,0,100,80);
        flipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) frame.getContentPane().getLayout();
                layout.show(frame.getContentPane(), "home");
            }
        });

        something.add(flipButton);
        return something;
    }

    public void show() {
        frame.setVisible(true);
    }
}