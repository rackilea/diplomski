// note that method and variable names should start with lower-case letters
addAccountForm(SCMain main, Set<String> inputSet) {
    String[] inputArray = inputSet.toArray(new String[0]);
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(inputArray);
    comboTest.setModel(model);
}