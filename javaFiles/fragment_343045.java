comboBox.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            textField.setText((String) comboBox.getSelectedItem());
        }
    }
});