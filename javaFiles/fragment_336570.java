private String getDateFromFields() {
  String month = monthComboBox.getSelectedItem();
  String day = dayComboBox.getSelectedItem();
  String year = yearComboBox.getSelectedItem();
  // Format this the way your database expects.
  String formattedDate = month + "/" + day + "/" + year;
}