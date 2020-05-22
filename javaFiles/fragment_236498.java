import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author Isaac
 * @see https://stackoverflow.com/a/18037704/230513
 */
public class Test2 {

    private JButton addNewColumnButton;
    private JButton calculateColumnButton;
    private JButton resultButton;
    private JLabel textLabel;
    private JTextField columnField;
    private JTextField resultField;
    private JComboBox columnListCB;
    private JTable table;
    private String[] tableCols = {
        "Fisrt Column", "Second Column", "Third Column"
    };
    private Object[][] tableRows = {
        {true, null, null, null, null, null, null, null},
        {true, null, null, null, null, null, null, null},
        {true, null, null, null, null, null, null, null},
        {true, null, null, null, null, null, null, null},
        {true, null, null, null, null, null, null, null},
        {true, null, null, null, null, null, null, null},
        {true, null, null, null, null, null, null, null},
        {true, null, null, null, null, null, null, null}
    };

    public Test2() {
        JFrame f = new JFrame("Test2");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(getUIPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JPanel getUIPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setBackground(Color.blue);

        JPanel center = new JPanel(new GridLayout());
        table = new JTable(tableRows, tableCols);
        table.setPreferredScrollableViewportSize(new Dimension(240, 120));
        center.add(new JScrollPane(table));

        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(Color.MAGENTA);
        Box eastPanelBox = Box.createVerticalBox();
        addNewColumnButton = new JButton("New Column");
        addNewColumnButton.setAlignmentX(Box.CENTER_ALIGNMENT);
        eastPanelBox.add(addNewColumnButton);
        eastPanelBox.add(Box.createVerticalStrut(14));
        columnField = new JTextField();
        columnField.setAlignmentX(Box.CENTER_ALIGNMENT);
        eastPanelBox.add(columnField);
        eastPanelBox.add(Box.createVerticalStrut(5));
        columnListCB = new JComboBox(tableCols);
        columnListCB.setAlignmentX(Box.CENTER_ALIGNMENT);
        eastPanelBox.add(columnListCB);
        eastPanelBox.add(Box.createVerticalStrut(5));
        calculateColumnButton = new JButton("Calculate Column");
        calculateColumnButton.setAlignmentX(Box.CENTER_ALIGNMENT);
        eastPanelBox.add(calculateColumnButton);
        eastPanel.add(eastPanelBox);

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        southPanel.setBackground(Color.green);
        resultButton = new JButton("Calculate");
        southPanel.add(resultButton);
        textLabel = new JLabel("Result:");
        southPanel.add(textLabel);
        resultField = new JTextField(10);
        southPanel.add(resultField);

        panel.add(center, BorderLayout.WEST);
        panel.add(southPanel, BorderLayout.SOUTH);
        panel.add(eastPanel, BorderLayout.EAST);
        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test2();
            }
        });
    }
}