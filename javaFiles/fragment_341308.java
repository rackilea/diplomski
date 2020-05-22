JButton btnAdd = new JButton("Add");
final JButton btnSubtract = new JButton("Subtract");

btnAdd.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent arg0) {
        int num1 = Integer.parseInt(textField.getText().toString());
        int num2 = Integer.parseInt(textField_1.getText().toString());
        int total = num1 + num2;
        btnSubtract.setEnabled(false);
        JOptionPane.showMessageDialog(null, total); 
    }
});
btnAdd.setBounds(144, 90, 89, 23);
btnSubtract.setBounds(144, 124, 89, 23);

frame.getContentPane().add(btnAdd);
frame.getContentPane().add(btnSubtract);