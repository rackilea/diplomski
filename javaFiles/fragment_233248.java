package com.ggl.testing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class HomeStylePizza implements Runnable {

    private static final Insets bottomInsets = new Insets(10, 10, 10, 10);
    private static final Insets normalInsets = new Insets(10, 10, 0, 10);

    // GUI components
    private JCheckBox cbPepproni, cbSausage, cbMushrooms, cbPineapple, cbOnion,
            cbBellPepper;

    private JRadioButton rbSmall, rbMedium, rbLarge, rbThinCrust,
            rbMediumCrust, rbPan;

    private JTextArea textArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new HomeStylePizza());
    } // End of main

    @Override
    public void run() {
        JFrame frame = new JFrame("Pizza Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        int gridy = 0;

        addComponent(mainPanel, createTitlePanel(), 0, gridy++, 2, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        addComponent(mainPanel, createToppingPanel(), 0, gridy, 1, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BorderLayout());
        eastPanel.add(createSizePanel(), BorderLayout.WEST);
        eastPanel.add(new JLabel(" "), BorderLayout.CENTER);
        eastPanel.add(createTypePanel(), BorderLayout.EAST);
        eastPanel.add(createButtonPanel(), BorderLayout.SOUTH);

        addComponent(mainPanel, eastPanel, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        addComponent(mainPanel, createTextAreaPanel(), 0, gridy++, 2, 1,
                bottomInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();

        JLabel lblWelcome = new JLabel("Welcome to Home Style Pizza Shop");
        Font titleFont = lblWelcome.getFont().deriveFont(20F);
        lblWelcome.setFont(titleFont);
        lblWelcome.setForeground(Color.RED);

        panel.add(lblWelcome);

        return panel;
    }

    private JPanel createToppingPanel() {
        Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
        Border emptyBorder = BorderFactory.createEmptyBorder(4, 10, 4, 10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createCompoundBorder(redBorder,
                emptyBorder));
        panel.setLayout(new GridLayout(0, 1));

        JLabel lblEachTopping = new JLabel("Each Topping: $1.50");
        lblEachTopping.setForeground(Color.RED);
        panel.add(lblEachTopping);

        cbPepproni = new JCheckBox("Pepperoni");
        cbSausage = new JCheckBox("Sausage");
        cbMushrooms = new JCheckBox("Mushrooms");
        cbPineapple = new JCheckBox("Pineapple");
        cbOnion = new JCheckBox("Onion");
        cbBellPepper = new JCheckBox("Bell Pepper");

        // add components to optionBox1
        panel.add(cbPepproni);
        panel.add(cbSausage);
        panel.add(cbMushrooms);
        panel.add(cbPineapple);
        panel.add(cbOnion);
        panel.add(cbBellPepper);

        return panel;
    }

    private JPanel createSizePanel() {
        Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
        Border emptyBorder = BorderFactory.createEmptyBorder(4, 10, 4, 10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createCompoundBorder(redBorder,
                emptyBorder));
        panel.setLayout(new GridLayout(0, 1));

        JLabel lblPizzaSize = new JLabel("Pizza Size");
        lblPizzaSize.setForeground(Color.RED);
        panel.add(lblPizzaSize);

        rbSmall = new JRadioButton("Small: $6.50");
        rbMedium = new JRadioButton("Medium: $8.50");
        rbLarge = new JRadioButton("Large: $10.00");

        // Create new ButtonGroup
        ButtonGroup group = new ButtonGroup();

        group.add(rbSmall);
        group.add(rbMedium);
        group.add(rbLarge);

        panel.add(rbSmall);
        panel.add(rbMedium);
        panel.add(rbLarge);

        return panel;
    }

    private JPanel createTypePanel() {
        Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
        Border emptyBorder = BorderFactory.createEmptyBorder(4, 10, 4, 10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createCompoundBorder(redBorder,
                emptyBorder));
        panel.setLayout(new GridLayout(0, 1));

        JLabel lblPizzaType = new JLabel("Pizza Type");
        lblPizzaType.setForeground(Color.RED);
        panel.add(lblPizzaType);

        rbThinCrust = new JRadioButton("Thin Crust");
        rbMediumCrust = new JRadioButton("Medium Crust");
        rbPan = new JRadioButton("Pan");

        // Create new ButtonGroup
        ButtonGroup group = new ButtonGroup();

        // add components to optionBox2 and grp1
        group.add(rbThinCrust);
        group.add(rbMediumCrust);
        group.add(rbPan);

        panel.add(rbThinCrust);
        panel.add(rbMediumCrust);
        panel.add(rbPan);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();

        JButton btnProcessSelection = new JButton("Process Selection");
        btnProcessSelection.addActionListener(new CalculateButtonHandler());
        panel.add(btnProcessSelection);

        return panel;
    }

    private JPanel createTextAreaPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel lblYourOrder = new JLabel("Your order:");
        panel.add(lblYourOrder, BorderLayout.NORTH);

        textArea = new JTextArea(6, 12);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
            int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0D, 1.0D, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    private class CalculateButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

        }

    }

} // End of HomeStylePizza class