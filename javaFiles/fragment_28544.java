private void passSelectedDateToPreviousActivity(Date selectedDate) {
    Intent data = new Intent();
    data.putExtra("DATE", selectedDate.toString());

    setResult(Activity.RESULT_OK, data);
    finish();
}