// define model
DefaultComboBoxModel model;
...

public void setComboBox(String[] list) {
    model = new DefaultComboBoxModel(list);
    comboBox.setModel(model);
}