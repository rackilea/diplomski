public static final int FIELD_LIST_COUNT = 7;

private List<JTextField> fieldList = new ArrayList<JTextField>();

// in constructor
for (int i = 0; i < FIELD_LIST_COUNT; i++) {
  JTextField field = new JTextField();
  fieldList.add(field);
  fieldHolderJPanel.add(field); // some JPanel that holds the text fields
}

// clear method
public void clearFields() {
  for (JTextField field : fieldList) {
    field.setText("");
  }
}