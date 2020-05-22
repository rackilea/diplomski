final JTextField employeeTextFieldToDo = new JTextField();
final JButton employeeAddCommentToDo = new JButton("Save");
...
employeeAddCommentToDo.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String comment = employeeTextFieldToDo.getText();
        JOptionPane.showConfirmDialog(SupTodoEmployeeFrame.this, "Votre commentaire est : " + comment, "comment message", JOptionPane.DEFAULT_OPTION);
    }
});