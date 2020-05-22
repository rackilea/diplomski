import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Index2 extends JPanel {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Index2());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private JLabel searchLabel;
    private JTextArea searchField;
    private JButton resultButton;
    private JEditorPane resultField;

    public Index2() {

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NORTH;
        setBackground(Color.WHITE);

        super.setLayout(gridbag);

        searchLabel = new JLabel("Enter some text:");
        searchField = new JTextArea("", 1, 20);
        JScrollPane scrollSearch = new JScrollPane(searchField);
        searchField.setLineWrap(true);
        searchField.setWrapStyleWord(true);
        searchField.setOpaque(true);

        searchField.setLineWrap(true);
        searchField.setWrapStyleWord(true);
        searchField.setOpaque(true);
        resultButton = new JButton("Count Occurences of Each Letter");
        resultField = new JEditorPane();
        JScrollPane scrollResult = new JScrollPane(resultField);
        resultField.setOpaque(true);
        resultField.setEditable(false);

        c.insets = new Insets(10, 10, 10, 10);


        c.gridx = 0;
        c.gridy = 0;
        add(searchLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        add(resultButton, c);

        c.weightx = 1;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        add(scrollSearch, c);

        c.gridx = 0;
        c.gridy = 3;
        add(scrollResult, c);

        ResultButtonHandler rbhandler = new ResultButtonHandler();
        resultButton.addActionListener(rbhandler);
    }

    class ResultButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String str = "<html><table border=1>";
            int count[] = new int[26];
            char letter[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            Random rnd = new Random();
            for (int i = 0; i < letter.length; i++) {
                if ((i + 1) % 2 == 0) {
                    int h = i - 1;
                    str += "<tr><td>" + letter[rnd.nextInt(letter.length)] + ": " + count[rnd.nextInt(letter.length)] + "</td><td>" + letter[rnd.nextInt(letter.length)] + ": " + count[rnd.nextInt(letter.length)] + "</td></tr>";
                }
            }
            str += "</table>";
            resultField.setContentType("text/html");
            resultField.setText(str);
            str = "";
        }
    }
}