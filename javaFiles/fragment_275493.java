JDialog dialog = null;
    JOptionPane optionPane = new JOptionPane();
    optionPane.setMessage("Set Message");
    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    String[] buttonTxt = {"Need Help","Help Me","Counting"};
    JButton[] buttons = new JButton[buttonTxt.length];
    for (int i = 0; i < buttonTxt.length; i++)
    {
        buttons[i] = new JButton(buttonTxt[i]);
        panel.add(buttons[i]);
    }
    optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
    optionPane.add(panel);
    dialog = optionPane.createDialog(null, "Icon/Text Button");
    dialog.setVisible(true);