import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Base {

    JFrame frame = new JFrame("Panel");
    BorderLayout bl = new BorderLayout();

    public Base() {
        MainPanel mainPanel = new MainPanel();
        LeftBar leftBar = new LeftBar(mainPanel);
        frame.setLayout(bl);
        frame.setSize(800, 600);
        frame.add(leftBar, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);

        Controller controller = new Controller(leftBar, mainPanel);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new Base();
    }

    public interface Pageable {

        public void showView(String name);

    }

    public interface Navigatable {

        public void addActionListener(ActionListener listener);

    }

    public class MainPanel extends JPanel implements Pageable {

        private CardLayout cl = new CardLayout();
        private JPanel panelHolder = new JPanel(cl);

        public MainPanel() {
            FirstPage firstPage = new FirstPage(this);
            SecondPage secondPage = new SecondPage(this);
            setLayout(new GridLayout(0, 1));

            panelHolder.add(firstPage, "firstPage");
            panelHolder.add(secondPage, "secondPage");

            cl.show(panelHolder, "firstPage");
            add(panelHolder);

        }

        public void showPanel(String panelIdentifier) {
            cl.show(panelHolder, panelIdentifier);
        }

        @Override
        public void showView(String name) {
            cl.show(panelHolder, name);
        }
    }

    public class LeftBar extends JPanel implements Navigatable {

        private JButton button;
        private MainPanel mainPanel;

        public LeftBar(MainPanel mainPanel) {
            this.mainPanel = mainPanel;

            setPreferredSize(new Dimension(200, 40));
            setLayout(new BorderLayout());
            setBackground(Color.black);

            button = new JButton("Show Second Page");

            add(button, BorderLayout.NORTH);
        }

        @Override
        public void addActionListener(ActionListener listener) {
            button.addActionListener(listener);
        }
    }

    public class SecondPage extends JPanel {

        MainPanel mainPanel;
        JButton button;

        public SecondPage(MainPanel mainPanel) {
            this.mainPanel = mainPanel;
            setBackground(Color.white);
            add(new JLabel("This is second page"));
        }
    }

    public class FirstPage extends JPanel {

        MainPanel mainPanel;
        JButton button;

        public FirstPage(MainPanel mainPanel) {
            this.mainPanel = mainPanel;
            setBackground(Color.GRAY);

            button = new JButton("Show page");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    mainPanel.showPanel("secondPage");
                }

            });

            add(button);
        }
    }

    public class Controller {

        private final Navigatable navigatable;
        private final Pageable pageable;

        public Controller(Navigatable navigatable, Pageable pageable) {
            this.navigatable = navigatable;
            this.pageable = pageable;

            navigatable.addActionListener(new ButtonListener());
        }

        class ButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {
                pageable.showView("secondPage");
            }
        }
    }
}