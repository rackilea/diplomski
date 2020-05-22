public void comboFilter(String enteredText) {
    if (!this.isPopupVisible()) {
        this.showPopup();
    }

    List<String> filterArray= new ArrayList<String>();
    for (int i = 0; i < array.size(); i++) {
        if (array.get(i).toLowerCase().contains(enteredText.toLowerCase())) {
            filterArray.add(array.get(i));
        }
    }
    if (filterArray.size() > 0) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.getModel();
        model.removeAllElements();
        for (String s: filterArray)
            model.addElement(s);

        JTextField textfield = (JTextField) this.getEditor().getEditorComponent();
        textfield.setText(enteredText);
    }
}