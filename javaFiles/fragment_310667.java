import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class SameTableModel {
    private JTable table;
    private DefaultTableModel model;

    public SameTableModel() {
        String[] cols = { "Col One", "Col Two" };
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);

        final JFrame frame = new JFrame();
        JButton button = new JButton("Open Dialog");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                DialogOne dialog = new DialogOne(frame, true, model);
                dialog.setVisible(true);
            }
        });

        frame.add(new JScrollPane(table));
        frame.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new SameTableModel();
            }
        });
    }
}

class DialogOne extends JDialog {
    private JTable table;
    private DefaultTableModel model;
    private JButton button;
    private JTextField fieldOne;
    private JTextField fieldTwo;

    public DialogOne(JFrame owner, boolean modal, DefaultTableModel model) {
        super(owner, modal);
        this.model = model;

        table = new JTable(model);
        button = createButton();
        JPanel fieldPanel = createFieldPanel();
        fieldPanel.add(button);

        JPanel eastPanel = new JPanel();
        eastPanel.add(fieldPanel);

        setLayout(new BorderLayout());
        add(new JScrollPane(table));
        add(eastPanel, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(owner);
    }

    private JPanel createFieldPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        fieldOne = new JTextField(12);
        fieldTwo = new JTextField(12);
        panel.add(fieldOne);
        panel.add(fieldTwo);
        return panel;
    }

    private JButton createButton() {
        JButton jbt = new JButton("Add Row");
        jbt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String text1 = fieldOne.getText();
                String text2 = fieldOne.getText();
                model.addRow(new Object[] { text1, text2});
                fieldOne.setText("");
                fieldTwo.setText("");
            }
        });
        return jbt;
    }
}