import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestingPage extends JFrame {

//    JFrame frame = new JFrame();
    JPanel panel01;
    JPanel panel02;
    JButton bttn1;

    public TestingPage() {
        super("Test");
        setBounds(700, 700, 650, 500);
        setLayout(new BorderLayout());
        Container cont = getContentPane();

        panel01 = new JPanel();
        panel02 = new JPanel();
        cont.add(panel01, BorderLayout.EAST);
        cont.add(panel02, BorderLayout.WEST);

        //setLayout(new BorderLayout());

        bttn1 = new JButton("Button");
        panel01.add(bttn1);
        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Runnable guiCreator = new Runnable() {
            @Override
            public void run() {
                TestingPage page = new TestingPage();
            }
        };
        javax.swing.SwingUtilities.invokeLater(guiCreator);
    }
}