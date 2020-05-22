class Utils {
    public void datePicker(Context mContext, EditText et) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            final Calendar myCalendar = Calendar.getInstance();
            year = myCalendar.get(Calendar.YEAR);
            month = myCalendar.get(Calendar.MONTH);
            day = myCalendar.get(Calendar.DAY_OF_MONTH);
        }
        picker = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                et.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            }
        }, year, month, day);
    picker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
    picker.show();
   }
}