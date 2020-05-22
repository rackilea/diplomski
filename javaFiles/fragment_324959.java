private void replaceComboModel(JComboBox<String> combo, Set<String> dataSet) {
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    model.insertElementAt(Constantes.COMBO_TEXT_TODOS, 0);
    for (String s: dataSet) {
        model.addElement(s);
    }
    combo.setModel(model);
}