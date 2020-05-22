import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminPage2 extends JPanel {
    private static final long serialVersionUID = 1L;
    public static final String TITLE = "Administrator Portal";
    private static final Font TITLE_FONT = new Font("Tahoma", Font.BOLD, 20);
    private static final String[] COL_NAMES = {"Name", "User Name", "Password"};
    private int txtFieldCols = 20;
    private JTextField nameField = new JTextField(txtFieldCols);
    private JTextField userNameField = new JTextField(txtFieldCols);
    private JPasswordField passwordField = new JPasswordField(txtFieldCols);
    private DefaultTableModel tableModel = new DefaultTableModel(COL_NAMES, 0);
    private JTable table = new JTable(tableModel);
    private JScrollPane tableScrollPane = new JScrollPane(table);

    public AdminPage2() {
        JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
        titleLabel.setFont(TITLE_FONT);
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));
        // of course you'd add ActionListeners or Actions to your buttons
        buttonPanel.add(new JButton("Add Library"));
        buttonPanel.add(new JButton("Delete"));
        buttonPanel.add(new JButton("View Library"));
        buttonPanel.add(new JButton("Logout"));

        JPanel textFieldPanel = new JPanel(new GridBagLayout());
        textFieldPanel.add(new JLabel("Name:"), createGbc(0, 0));
        textFieldPanel.add(nameField, createGbc(1, 0));
        textFieldPanel.add(new JLabel("User Name:"), createGbc(0, 1));
        textFieldPanel.add(userNameField, createGbc(1, 1));
        textFieldPanel.add(new JLabel("Password:"), createGbc(0, 2));
        textFieldPanel.add(passwordField, createGbc(1, 2));

        JPanel wrapTfPanel = new JPanel();
        wrapTfPanel.add(textFieldPanel);

        Dimension scrollPanePrefSz = tableScrollPane.getPreferredSize();
        int w = scrollPanePrefSz.width;
        int h = scrollPanePrefSz.height / 2;
         scrollPanePrefSz = new Dimension(w, h);
         tableScrollPane.setPreferredSize(scrollPanePrefSz);

        // put together main JPanel components
        int ebGap = 4;
        setBorder(BorderFactory.createEmptyBorder(ebGap, ebGap, ebGap, ebGap));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalStrut(5));
        add(titlePanel);
        add(Box.createVerticalStrut(5));
        add(buttonPanel);
        add(Box.createVerticalStrut(5));
        add(wrapTfPanel);
        add(Box.createVerticalStrut(5));
        add(tableScrollPane);
    }

    // create constraints to use when adding component to GridBagLayout
    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = x == 0 ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int in = 10;
        int leftIn = x == 0 ? 4 * in : in;
        gbc.insets = new Insets(in, leftIn, in, in);
        return gbc;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        AdminPage2 mainPanel = new AdminPage2();
        JFrame frame = new JFrame("Administrator Page");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}