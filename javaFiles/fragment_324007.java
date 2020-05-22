//The Button
JButton button = new JButton("Klick me :D");
button.setBounds(154, 250, 92, 32);
button.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        String string = inputfield.getText();
        outputfield.setText(string);
    }
});
add(button);