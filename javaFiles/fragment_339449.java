import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

public class Frame1 extends JFrame {

    JLabel one = new JLabel("one");
    JLabel two = new JLabel("two");
    JLabel three = new JLabel("three");

    JTextField oneF = new JTextField(20);
    JTextField twoF = new JTextField(20);
    JTextField threeF = new JTextField(20);

    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("menu");

    public Frame1() {

        setTitle("GridBagLayout Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0}; //this defines 4 rows
        //make 2 last empty row grow 
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0,1.0};

        //do the same for columns 
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0,1.0};

        getContentPane().setLayout(gridBagLayout);

        menuBar.add(menu);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 5;
        c.fill = c.HORIZONTAL;
        c.anchor = c.NORTH;
        c.insets = new Insets(5, 5, 5, 0);
        getContentPane().add(menuBar, c);

        //better have a new GridBagConstraints for each component added 
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 1;
        c1.gridwidth = 1;
        c1.fill = c1.NONE;
        c1.anchor = c1.NORTH;
        c1.insets = new Insets(5, 5, 0, 5);
        getContentPane().add(one, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 1;
        c2.gridy = 1;
        c2.fill = c2.NONE;
        c2.anchor = GridBagConstraints.NORTHWEST;
        c2.insets = new Insets(5, 5, 0, 5);
        getContentPane().add(oneF, c2);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame1();
    }
}