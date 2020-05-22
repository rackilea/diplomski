private void initializeAllTimeFields() {
    for (int i = 0; i < NUMBER_OF_PERSONNEL; i++) {
        totalOT1Field[i] = initializeTimeFields(OT1Field[i]);
        totalOT2Field[i] = initializeTimeFields(OT2Field[i]);
        totalSTField[i] = initializeTimeFields(STField[i]);
    }
}

private JTextField initializeTimeFields(JTextField[] timeFields) {
    JTextField totalField = new JTextField();
    totalField.setEditable(false);
    OvertimeSumListener listener = new OvertimeSumListener(timeFields, totalField);
    for (int i = 0; i < timeFields.length; i++) {
        timeFields[i] = new JTextField();
        timeFields[i].getDocument().addDocumentListener(listener);
    }
    return totalField;
}