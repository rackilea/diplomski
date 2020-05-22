final JTextField field = new JTextField(20);
field.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = field.getText();
        System.out.println(text);
        field.setText(text);
    }
});