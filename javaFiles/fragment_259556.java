import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class SSCCE {

    private javax.swing.JButton addGroupButton;
    private javax.swing.JTextField addGroupTextField;
    private javax.swing.JButton addSlaveButton;
    private javax.swing.JList allSlavesList;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteSlaveButton;
    private javax.swing.JComboBox groupComboBox;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton renameButton;
    private javax.swing.JLabel allSlavesLabel;
    private javax.swing.JLabel slavesInGroupLabel;
    private javax.swing.JList slavesInGroupList;
    private JLabel groupNameLabel;

    public SSCCE() {

    }

    public JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.GridBagLayout());

        addGroupButton = new javax.swing.JButton();
        addGroupTextField = new javax.swing.JTextField();
        addSlaveButton = new javax.swing.JButton();
        allSlavesList = new javax.swing.JList();
        deleteButton = new javax.swing.JButton();
        deleteSlaveButton = new javax.swing.JButton();
        groupComboBox = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        renameButton = new javax.swing.JButton();
        allSlavesLabel = new javax.swing.JLabel("All slaves");
        slavesInGroupLabel = new javax.swing.JLabel("Devices in this group");
        groupNameLabel = new JLabel("Groupd name:");
        slavesInGroupList = new javax.swing.JList();
        groupComboBox.setModel(new DefaultComboBoxModel(new Object[] { "one", "two", "three" }));
        addGroupButton.setText("add");
        allSlavesList.setModel(new DefaultListModel());
        slavesInGroupList.setModel(new DefaultListModel());
        renameButton.setText("rename");
        deleteButton.setText("delete");
        addSlaveButton.setText("->");
        deleteSlaveButton.setText("<-");
        allSlavesList.setVisibleRowCount(4);
        jScrollPane2.setViewportView(allSlavesList);
        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ((DefaultListModel) allSlavesList.getModel()).addElement("one");
        ((DefaultListModel) allSlavesList.getModel()).addElement("two");
        ((DefaultListModel) allSlavesList.getModel()).addElement("three");

        ((DefaultListModel) slavesInGroupList.getModel()).addElement("one");
        ((DefaultListModel) slavesInGroupList.getModel()).addElement("two");
        ((DefaultListModel) slavesInGroupList.getModel()).addElement("three");
        slavesInGroupList.setVisibleRowCount(4);
        jScrollPane3.setViewportView(slavesInGroupList);
        jScrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Let's split your display in 3 rows
        panel = new JPanel(new GridBagLayout());
        JPanel row1 = new JPanel(new BorderLayout(3, 3));
        JPanel row2 = new JPanel(new GridBagLayout());
        JPanel row3 = new JPanel(new GridBagLayout());

        // Use GBL to make three rows and give all extra vertical space to the last one
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(3, 3, 3, 3);
        panel.add(row1, gbc);
        panel.add(row2, gbc);
        // Gives all extra v-space to last row
        gbc.weighty = 1.0;
        panel.add(row3, gbc);

        GridBagConstraints gridBagConstraints;

        // Set up row 1
        row1.add(groupNameLabel, BorderLayout.WEST);
        row1.add(addGroupButton, BorderLayout.EAST);
        row1.add(addGroupTextField);// In the middle so that it takes all the width and it won't stretch vertically because row1 has weighty
                                    // set to 0.0

        // Set up row 2
        // We give all extra space to the combo box
        gbc = new java.awt.GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        row2.add(groupComboBox, gbc);
        gbc.weightx = 0;
        row2.add(deleteButton, gbc);
        row2.add(renameButton, gbc);

        // Set up row3
        gbc = new java.awt.GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        row3.add(allSlavesLabel, gbc);
        gbc.gridx = 2;
        row3.add(slavesInGroupLabel, gbc);

        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.gridheight = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;

        row3.add(jScrollPane2, gbc);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.weightx = 0;
        row3.add(addSlaveButton, gbc);
        gbc.gridy = 2;
        row3.add(deleteSlaveButton, gbc);

        gbc.gridheight = 2;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;

        row3.add(jScrollPane3, gbc);

        return panel;

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SSCCE a = new SSCCE();
                JDialog dialog = new JDialog();
                dialog.add(a.createPanel());
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                // JOptionPane.showConfirmDialog(null, a.createPanel(), "centrum.manageGroups", JOptionPane.OK_CANCEL_OPTION);
            }
        });
    }

}