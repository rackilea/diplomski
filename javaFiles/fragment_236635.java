import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MyCalc extends JApplet implements ActionListener {

    /**
 * 
 */
    protected static final long serialVersionUID = 3169756252830354073L;

    private JMenuBar menuBar = new JMenuBar();
    private JMenu edit = new JMenu("Edit");
    private JMenu view = new JMenu("View");
    private JMenu help = new JMenu("Help");

    // Instantiated all JPanels used in this Applet
    //private JPanel[] rows = { new JPanel(), new JPanel(), new JPanel(),
    //      new JPanel(), new JPanel(), new JPanel(), new JPanel() };

    JTextField calc = new JTextField(1);

    private JButton[] buttons = { new JButton("Backspace"), new JButton("CE"),
            new JButton("C"), new JButton("MC"), new JButton("7"),
            new JButton("8"), new JButton("9"), new JButton("/"),
            new JButton("sqrt"), new JButton("MR"), new JButton("4"),
            new JButton("5"), new JButton("6"), new JButton("*"),
            new JButton("%"), new JButton("MS"), new JButton("1"),
            new JButton("2"), new JButton("3"), new JButton("-"),
            new JButton("1/x"), new JButton("M+"), new JButton("0"),
            new JButton("+/-"), new JButton("."), new JButton("+"),
            new JButton("=") };

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttons[0]) {

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new JFrame();
                MyCalc calc = new MyCalc();
                calc.init();
                frame.add(calc);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public void init() {
        setName("Calculator Applet");
        menuBar.add(edit);
        menuBar.add(view);
        menuBar.add(help);
        setJMenuBar(menuBar);

        Container contentPane = getContentPane();

        calc.setText("0.");
        calc.setHorizontalAlignment(JTextField.RIGHT);
        JPanel topButtonPanel = new JPanel(new GridLayout(1, 0));
        for (int i = 0; i < 3; i++) {
            topButtonPanel.add(buttons[i]);
        }

        JPanel numberButtonPanel = new JPanel(new GridLayout(4, 6));
        for (int i = 3; i < 26; i++) {
            numberButtonPanel.add(buttons[i]);
        }

        JPanel centerWrapper = new JPanel(new BorderLayout());
        centerWrapper.add(calc, BorderLayout.PAGE_START);
        centerWrapper.add(topButtonPanel);
        centerWrapper.add(numberButtonPanel, BorderLayout.PAGE_END);

        contentPane.setLayout(new GridBagLayout());
        contentPane.add(centerWrapper);
    }
}