import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Test().createAndShowUI();
            }
        });
    }

    private void createAndShowUI() {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        initComponents(frame);

        frame.pack();//call pack 

        printPanelCompPoints(mainPanel);//produces correct coords

        frame.setVisible(true);
    }

    private JPanel mainPanel;

    private void initComponents(JFrame frame) {
        mainPanel = new JPanel(new BorderLayout());
        JPanel centerPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();

        centerPanel.add(new JLabel("CENTER"));
        northPanel.add(new JLabel("NORTH"));
        eastPanel.add(new JLabel("EAST"));
        southPanel.add(new JLabel("SOUTH"));
        westPanel.add(new JLabel("WEST"));

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        mainPanel.add(eastPanel, BorderLayout.EAST);
        mainPanel.add(westPanel, BorderLayout.WEST);

       frame.getContentPane().add(mainPanel);

       printPanelCompPoints(mainPanel);//produces all 0's
    }

    private void printPanelCompPoints(JPanel mainPanel) {
        for (int i = 0; i < mainPanel.getComponentCount(); i++) {
            System.out.println(mainPanel.getComponent(i).getX() + ", " + mainPanel.getComponent(i).getY());
        }
    }
}