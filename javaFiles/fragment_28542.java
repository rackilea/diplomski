private fun passSelectedDateToPreviousActivity(selectedDate: Date) {
    val data = Intent()
    data.putExtra("DATE", selectedDate.toString());

    setResult(Activity.RESULT_OK, data);
    finish()
}