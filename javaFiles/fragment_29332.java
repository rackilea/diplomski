JPanel panel = new JPanel(new GridBagLayout());
    JLabel label = new JLabel("Enter message:");
    JTextArea msgBodyContainer = new JTextArea(10, 20);
    msgBodyContainer.setAutoscrolls(true);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(4, 4, 4, 4);
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    panel.add(label, gbc);
    gbc.gridx++;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    panel.add(new JScrollPane(msgBodyContainer), gbc);

    String[] options = new String[]{"OK", "Cancel"};
    int option = JOptionPane.showOptionDialog(null, panel, "Message ",
                                                                                        JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                                                                        null, options, options[1]);