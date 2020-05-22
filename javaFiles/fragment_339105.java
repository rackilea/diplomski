package com.ggl.testing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AllGUI {

    private static final Insets normalInsets = new Insets(10, 10, 0, 10);

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new AllGUI().createAllGUI();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    public void createAllGUI() {
        JFrame frame = new JFrame("All File Types Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(createMainPanel());
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());

        int gridy = 0;

        JLabel groupMessageIdTitle = new JLabel("Group Message Id:");
        addComponent(formPanel, groupMessageIdTitle, 0, gridy, 1, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JTextField groupMessageIdText = new JTextField("", 10);
        addComponent(formPanel, groupMessageIdText, 1, gridy, 1, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JLabel isoDateTimeTitle = new JLabel("ISO Creation Date/Time:");
        addComponent(formPanel, isoDateTimeTitle, 2, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JTextField isoDateTimeText = new JTextField("", 10);
        addComponent(formPanel, isoDateTimeText, 3, gridy++, 1, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JLabel notificationIdTitle = new JLabel("Notification Id:");
        addComponent(formPanel, notificationIdTitle, 0, gridy, 1, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JTextField notificationIdText = new JTextField("", 10);
        addComponent(formPanel, notificationIdText, 1, gridy, 1, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JLabel notificationAcctIdTitle = new JLabel("Notification Account Id:");
        addComponent(formPanel, notificationAcctIdTitle, 2, gridy, 1, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JTextField notificationAcctIdText = new JTextField("", 10);
        addComponent(formPanel, notificationAcctIdText, 3, gridy++, 1, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JLabel numberOfEntriesTitle = new JLabel("Number of Entries:");
        addComponent(formPanel, numberOfEntriesTitle, 0, gridy, 1, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JTextField numberOfEntriesText = new JTextField("", 10);
        addComponent(formPanel, numberOfEntriesText, 1, gridy, 1, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JLabel sumOfAmountsTitle = new JLabel("Sum of Amounts:");
        addComponent(formPanel, sumOfAmountsTitle, 2, gridy, 1, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JTextField sumOfAmountsText = new JTextField("", 10);
        addComponent(formPanel, sumOfAmountsText, 3, gridy++, 1, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JLabel fileTypeTitle = new JLabel("Camt54 File Type:");
        addComponent(formPanel, fileTypeTitle, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        String[] fileTypes = { "OTC-R Message", "Home-Banking",
                "Cleared Checks" };
        JComboBox<String> fileTypesComboBox = new JComboBox<>(fileTypes);
        addComponent(formPanel, fileTypesComboBox, 1, gridy, 1, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JPanel confirmPanel = new JPanel();
        JButton confirmButton = new JButton("Confirm");
        confirmPanel.add(confirmButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(confirmPanel, BorderLayout.SOUTH);

        return mainPanel;
    }

    private void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
            int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 0.0D, 0.0D, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

}