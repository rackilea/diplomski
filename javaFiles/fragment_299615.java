JButton btnSubmit = new JButton("Submit");
btnSubmit.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {
        String afValue = AF.getText().trim();
        String alValue = AL.getText().trim();
        String titleValue = titleBook.getText().trim();
        String dropRGValue = dropRG.getSelectedItem().toString();
        if (afValue.isEmpty() || alValue.isEmpty() || titleValue.isEmpty() || dropRGValue.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Can't have empty fields!");
        } else {
            //SQL code
            JOptionPane.showMessageDialog(null, "Entry Saved!");
        }
    }
});