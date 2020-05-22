import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class MainFrame extends JFrame {
    public static MainFrame instance;
    public static final Container startPage = createStartPage();
    public static final Container question1Page = createQuestion1Page();
    public static final Container correctPage = createCorrectPage();

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        instance = new MainFrame();
        instance.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        instance.setTitle("Who wants to be a Millionaire!");
        instance.setVisible(true);
        navigateTo(startPage);
    }

    static void navigateTo(Container page) {
        instance.setContentPane(page);
        instance.setSize(page.getSize());
    }

    static Container createStartPage() {
        JPanel result = new JPanel(null);
        result.setSize(1280, 800);

        //b1
        ImageIcon image = new ImageIcon("image1.png");
        JButton b1 = new JButton(image);
        b1.setBounds(400, 650, 414, 60);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo(question1Page);
            }
        });
        result.add(b1);

        //b2
        ImageIcon bg = new ImageIcon("image2.png");
        JLabel b2 = new JLabel(bg);
        b2.setBounds(1, 1, 1280, 800);
        result.add(b2);
        return result;
    }

    static Container createQuestion1Page() {
        JPanel result = new JPanel(null);
        result.setSize(1280, 800);

        //qC1
        ImageIcon c1 = new ImageIcon("choice1.png");
        JButton qC1 = new JButton(c1);
        qC1.setBounds(80, 580, 526, 82);
        qC1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo(correctPage);
            }
        });
        result.add(qC1);

        //qC2
        ImageIcon c2 = new ImageIcon("choice2.png");
        JButton qC2 = new JButton(c2);
        qC2.setBounds(650, 580, 526, 82);
        result.add(qC2);

        //qL1
        ImageIcon q1 = new ImageIcon("question1.png");
        JLabel qL1 = new JLabel(q1);
        qL1.setBounds(1, 1, 1280, 800);
        result.add(qL1);
        return result;
    }

    static Container createCorrectPage() {
        JPanel result = new JPanel(null);
        result.setSize(420, 230);

        //correct2
        ImageIcon correct1 = new ImageIcon("correct.png");
        JLabel correct2 = new JLabel(correct1);
        correct2.setBounds(1, 1, 420, 230);
        result.add(correct2);
        return result;
    }
}