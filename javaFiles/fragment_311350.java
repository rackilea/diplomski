protected JPanel createPanel(String input) {
    JPanel inst = new JPanel();
    inst.setVisible(true);
    final JTextField textField = new JTextField();
    textField.setVisible(true);
    textField.setBounds(12, 12, 80, 30);
    JButton button = new JButton();        
    button.setVisible(true);
    button.setBounds(100, 12, 80, 30);
    final JTextPane textPane = new JTextPane();
    textPane.setBounds(12, 54, 168, 40);
    inst.add(textPane);
    textPane.setVisible(true);

    button.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent arg0) {
            textPane.setText(textPane.getText() + textField.getText());
        }});

    inst.setLayout(null);
    inst.add(button);
    inst.add(textField);
    ary.add(inst);
    tabIndex = index;
    index++;
    return inst;
}