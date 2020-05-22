import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class MainMenu extends JFrame implements ActionListener {

    JPanel pnl = new JPanel();
    JPanel grid = new JPanel(new GridLayout(3, 1));
    JRadioButton input1 = new JRadioButton("Enter New Information", true);
    JRadioButton input2 = new JRadioButton("Load from a CSV file");
    JRadioButton input3 = new JRadioButton("Save to a CSV file");
    ButtonGroup inputs = new ButtonGroup();
    JButton b1 = new JButton("OK");
    JButton b2 = new JButton("Cancel");
    JTextArea txtArea = new JTextArea(5, 25);

    @Override
    public void actionPerformed(ActionEvent event2) {

        txtArea.setText(event2.getActionCommand() + " Clicked");
        Object source = event2.getSource();

        if (source == b1 && input1.isSelected()) {
            System.exit(0);
        }
        if (source == b1 && input2.isSelected()) {

            final JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(null);
            System.exit(0);
        }
        if (event2.getSource() == b1 && input3.isSelected()) {
            System.exit(0);
        }
        if (event2.getSource() == b2) {
            System.exit(0);
        }
    }

    public MainMenu() {

        super("Main Menu");
        setSize(300, 200);
        Container contentPane = getContentPane();
        ButtonGroup buttonGroup = new javax.swing.ButtonGroup();
        inputs.add(input1);
        inputs.add(input2);
        inputs.add(input3);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(grid);
        add(pnl);
        grid.add(input1);
        grid.add(input2);
        grid.add(input3);
        grid.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnl.add(b1);
        pnl.add(b2);
        pnl.add(txtArea);

        b1.addActionListener(this);
        b2.addActionListener(this);
        input1.addActionListener(this);
        input2.addActionListener(this);
        input3.addActionListener(this);
        contentPane.add("North", grid);
        contentPane.add("South", pnl);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                MainMenu frame = new MainMenu();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}