Calendar today = Calendar.getInstance();
int dayOfMonth = today.get(Calendar.DAY_OF_MONTH);
int month = today.get(Calendar.MONTH);
int year = today.get(Calendar.YEAR);
if (month == Calendar.JUNE && dayOfMonth == 29 && year == 2014) {
  // June 29, 2014
  myButton.setEnabled(true);
}
else
{
  // NOT June 29, 2014
  myButton.setEnabled(false);
}