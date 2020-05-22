import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MyWindow {

    private static final long serialVersionUID = 1L;
    private JPanel menupanel = new JPanel();
    private JFrame frame = new JFrame("Image Application");

    public MyWindow() {
        // Menu
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JButton button = new JButton("Reset");
        // Buttons
        menupanel.add(new JButton("Allign Left"));
        menupanel.add(new JButton("Allign Center"));
        menupanel.add(new JButton("Allign Right"));
        // Picture
        JPanel p1 = new JPanel();
        p1.setBackground(Color.RED);
        // 2x JLabels and ComboBoxes to get the preferred dimensions
        JPanel p2 = new JPanel();
        p2.setBackground(Color.ORANGE);
        JLabel b2 = new JLabel("Width:  ");
        p2.add(b2);
        JTextField box1 = new JTextField(25);
        p2.add(box1);
        JPanel p3 = new JPanel();
        p3.setBackground(Color.BLUE);
        JLabel b3 = new JLabel("Height: ");
        JTextField box2 = new JTextField(25);
        p3.add(b3);
        p3.add(box2);
        // Resize Button
        JPanel p4 = new JPanel();
        p4.setBackground(Color.MAGENTA);
        JButton b4 = new JButton("Resize");
        // Adding Components to their panels
        p4.add(b4);
        menu.add(button);
        menubar.add(menu);
        // add all of the panels to JFrame
        frame.setLayout(new GridLayout(6, 0, 5, 5));        
        frame.add(menupanel);
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        frame.setJMenuBar(menubar);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyWindow w = new MyWindow();
            }
        });
    }
}