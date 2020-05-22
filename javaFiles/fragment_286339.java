comboBox.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int index = combo.getSelectedIndex();
        if (index == 0) {
            //disable some textfields or change format if it's a JFormattedField
        } 
    }
});