package com.ggl.envelopes.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ggl.envelopes.model.Address;
import com.ggl.envelopes.model.EnvelopeModel;
import com.ggl.envelopes.model.State;

public class AddressPanel {

    private static final Insets entryInsets = 
            new Insets(0, 10, 4, 10);
    private static final Insets spaceInsets = 
            new Insets(10, 10, 4, 10);

    private Address currentAddress;

    private AddressComboBoxItemListener listener;

    private DefaultComboBoxModel<Address> addressComboBoxModel;
    private DefaultComboBoxModel<State> stateComboBoxModel;

    private EnvelopeModel model;

    private JButton updateButton;
    private JButton deleteButton;

    private JComboBox<Address> addressComboBox;
    private JComboBox<State> stateComboBox;

    private JLabel messageLabel;

    private JPanel mainPanel;

    private JTextField nameField;
    private JTextField address1Field;
    private JTextField address2Field;
    private JTextField cityField;
    private JTextField zip5Field;
    private JTextField zip4Field;

    public AddressPanel(EnvelopeModel model) {
        this.model = model;
        this.listener = new AddressComboBoxItemListener();
        this.addressComboBoxModel = 
                new DefaultComboBoxModel<Address>();
        this.stateComboBoxModel =
                new DefaultComboBoxModel<State>();
        createPartControl();
    }

    private void createPartControl() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        int gridy = 0;

        if (model.getAddresses().size() > 0) {
            gridy = createAddressComboBox(gridy);
        }

        gridy = createAddressControl(gridy);
    }

    private int createAddressComboBox(int gridy) {
        JLabel addressesLabel = new JLabel("Addresses:");
        addressesLabel.setHorizontalAlignment(JLabel.LEFT);
        addComponent(mainPanel, addressesLabel, 0, gridy, 
                1, 1, spaceInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        buildAddressComboBoxModel();

        addressComboBox = new JComboBox<Address>(addressComboBoxModel);
        addressComboBox.addItemListener(listener);
        addComponent(mainPanel, addressComboBox, 1, gridy++, 
                4, 1, spaceInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        return gridy;
    }

    private int createAddressControl(int gridy) {
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setHorizontalAlignment(JLabel.LEFT);
        addComponent(mainPanel, nameLabel, 0, gridy, 
                1, 1, spaceInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        nameField = new JTextField(30);
        nameLabel.setLabelFor(nameField);
        addComponent(mainPanel, nameField, 1, gridy++, 
                4, 1, spaceInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        JLabel address1Label = new JLabel("Address:");
        address1Label.setHorizontalAlignment(JLabel.LEFT);
        addComponent(mainPanel, address1Label, 0, gridy, 
                1, 1, entryInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        address1Field = new JTextField(30);
        address1Label.setLabelFor(address1Field);
        addComponent(mainPanel, address1Field, 1, gridy++, 
                4, 1, entryInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        JLabel address2Label = new JLabel(" ");
        address2Label.setHorizontalAlignment(JLabel.LEFT);
        addComponent(mainPanel, address2Label, 0, gridy, 
                1, 1, entryInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        address2Field = new JTextField(30);
        address2Label.setLabelFor(address2Field);
        addComponent(mainPanel, address2Field, 1, gridy++, 
                4, 1, entryInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        JLabel dummyLabel = new JLabel(" ");
        dummyLabel.setHorizontalAlignment(JLabel.LEFT);
        addComponent(mainPanel, dummyLabel, 0, gridy, 
                1, 1, entryInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        cityField = new JTextField(10);
        dummyLabel.setLabelFor(cityField);
        addComponent(mainPanel, cityField, 1, gridy, 
                1, 1, entryInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        buildStateComboBoxModel();

        stateComboBox = new JComboBox<State>(stateComboBoxModel);
        stateComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getActionCommand()
                        .equals("comboBoxEdited")) {
                    String s = stateComboBox.getSelectedItem()
                            .toString();
                    State t = model.getStateByAbbreviation(s);
                    if (t != null) {
                        stateComboBox.setSelectedItem(t);
                    }
                }
            }   
        });
        stateComboBox.setEditable(true);
        addComponent(mainPanel, stateComboBox, 2, gridy, 
                1, 1, entryInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        zip5Field = new JTextField(6);
        addComponent(mainPanel, zip5Field, 3, gridy, 
                1, 1, entryInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        zip4Field = new JTextField(6);
        addComponent(mainPanel, zip4Field, 4, gridy++, 
                1, 1, entryInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        messageLabel = new JLabel(" ");
        messageLabel.setHorizontalAlignment(JLabel.LEFT);
        addComponent(mainPanel, messageLabel, 0, gridy++, 
                5, 1, entryInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        JPanel buttonPanel = createButtonPanel();
        addComponent(mainPanel, buttonPanel, 0, gridy++, 
                5, 1, spaceInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);

        return gridy;
    }

    private void buildAddressComboBoxModel() {
        addressComboBoxModel.removeAllElements();
        for (Address address : model.getAddresses()) {
            addressComboBoxModel.addElement(address);
        }
    }

    private void buildStateComboBoxModel() {
        stateComboBoxModel.removeAllElements();
        for (State state : model.getStates()) {
            stateComboBoxModel.addElement(state);
        }
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 20, 0));

        JButton addButton = new JButton("Add Address");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String message = checkFields();
                if (message.equals("")) {
                    Address address = createAddress();
                    model.addAddress(address);
                    if (model.getAddresses().size() == 1) {
                        mainPanel.removeAll();
                        int gridy = 0;
                        gridy = createAddressComboBox(gridy);
                        gridy = createAddressControl(gridy);
                    } else {
                        clearFields();
                        addressComboBox.removeItemListener(listener);
                        buildAddressComboBoxModel();
                        addressComboBox.addItemListener(listener);
                    }
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Address \"" + 
                            address.getName() + "\" saved");
                } else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText(message);
                }
            }           
        });
        addButton.setHorizontalAlignment(JButton.CENTER);
        buttonPanel.add(addButton);

        updateButton = new JButton("Change Address");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String message = checkFields();
                if (message.equals("")) {
                    Address changedAddress = createAddress();
                    updateReturnSenderAddresses(
                            currentAddress, changedAddress);
                    model.updateAddress(
                            currentAddress, changedAddress);
                    clearFields();
                    addressComboBox.removeItemListener(listener);
                    buildAddressComboBoxModel();
                    addressComboBox.addItemListener(listener);
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Address \"" + 
                            currentAddress.getName() + "\" changed");
                    updateButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                } else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText(message);
                }
            }   
        });
        updateButton.setEnabled(false);
        updateButton.setHorizontalAlignment(JButton.CENTER);
        buttonPanel.add(updateButton);

        deleteButton = new JButton("Delete Address");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                deleteReturnSenderAddresses(currentAddress);
                model.removeAddress(currentAddress);
                clearFields();
                addressComboBox.removeItemListener(listener);
                buildAddressComboBoxModel();
                addressComboBox.addItemListener(listener);
                messageLabel.setForeground(Color.GREEN);
                messageLabel.setText("Address \"" + 
                        currentAddress.getName() + "\" deleted");
                updateButton.setEnabled(false);
                deleteButton.setEnabled(false);
            }   
        });
        deleteButton.setEnabled(false);
        deleteButton.setHorizontalAlignment(JButton.CENTER);
        buttonPanel.add(deleteButton);

        return buttonPanel;
    }

    private void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, 
            Insets insets, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0D, 1.0D, anchor, 
                fill, insets, 0, 0);
        container.add(component, gbc);
    }

    private String checkFields() {
        String message = "";

        State state = null;
        try {
            state = (State) stateComboBox.getSelectedItem();
        } catch (ClassCastException e) {
            message = "State abbreviation is invalid";
            return message;
        }

        if (state == null) {
            message = "State abbreviation is null";
            return message;
        }

        String abbreviation = state.getAbbreviation();

        boolean n = nameField.getText().trim().isEmpty();
        boolean a = address1Field.getText().trim().isEmpty();
        boolean c = cityField.getText().trim().isEmpty();
        boolean s = abbreviation.trim().isEmpty();
        boolean z = zip5Field.getText().trim().isEmpty();

        if (n || a || c || s || z) {
            message = "One or more required fields are empty";
            return message;
        }

//      boolean x = stateField.getText().trim().length() > 2;
        boolean g = isNumeric(zip5Field.getText().trim());

//      if (x) {
//          message = "State is more than 2 characters";
//          return message;
//      }

        if (!g) {
            message = "Zip 5 is not numeric";
            return message;
        }

        if (zip4Field.getText().trim().isEmpty()) {
            return message;
        } else {
            if (isNumeric(zip4Field.getText().trim())) {
                return message;
            } else {
                message = "Zip 4 is not numeric";
                return message;
            }
        }
    }

    private boolean isNumeric(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Integer setZip(String s) {
        return (s.isEmpty()) ? null : Integer.valueOf(s);
    }

    private Address createAddress() {
        String abbreviation = 
                ((State) stateComboBox.getSelectedItem())
                .getAbbreviation();

        return new Address(
                nameField.getText().trim(),
                address1Field.getText().trim(),
                address2Field.getText().trim(),
                cityField.getText().trim(),
                abbreviation.toUpperCase(),
                setZip(zip5Field.getText().trim()),
                setZip(zip4Field.getText().trim())
                );
    }

    private void clearFields() {
        nameField.setText("");
        address1Field.setText("");
        address2Field.setText("");
        cityField.setText("");
        stateComboBox.setSelectedIndex(0);
        zip5Field.setText("");
        zip4Field.setText("");
    }

    private void setFields(Address address) {
        nameField.setText(address.getName());
        address1Field.setText(address.getAddressLine1());
        address2Field.setText(address.getAddressLine2());
        cityField.setText(address.getCity());
        stateComboBox.setSelectedItem(
                model.getStateByAbbreviation(address.getState()));
        zip5Field.setText(String.format("%05d", address.getZip5()));
        zip4Field.setText(displayZip4(address.getZip4()));
    }

    private String displayZip4(Integer value) {
        return (value == null) ? "" : String.format("%04d", value);
    }

    private void updateReturnSenderAddresses(Address oldAddress,
            Address newAddress) {
        if (oldAddress.equals(model.getReturnAddress())) {
            model.setReturnAddress(newAddress);
        }
        if (oldAddress.equals(model.getSenderAddress())) {
            model.setSenderAddress(newAddress);
        }
    }

    private void deleteReturnSenderAddresses(Address address) {
        if (address.equals(model.getReturnAddress())) {
            model.clearReturnAddress();
        }
        if (address.equals(model.getSenderAddress())) {
            model.clearSenderAddress();
        }
    }

    public void refresh() {
        messageLabel.setText(" ");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public class AddressComboBoxItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
            currentAddress = (Address) 
                    addressComboBox.getSelectedItem();
            setFields(currentAddress);
            updateButton.setEnabled(true);
            deleteButton.setEnabled(true);
        }

    }

}