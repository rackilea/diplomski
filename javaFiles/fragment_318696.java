private void showDatePicker() {

   long timeInMillis = getmilifromdate(tvDate.getText().toString);
   c.setTimeInMillis(timeInMillis);

    mYear = c.get(Calendar.YEAR);
    mMonth = c.get(Calendar.MONTH);
    mDay = c.get(Calendar.DAY_OF_MONTH);

    DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
            new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    //2018-08-15
                    selectedDate = year + "-" + ((monthOfYear + 1)) + "-" + (dayOfMonth);
    c.set(year, monthOfYear, dayOfMonth);
                    tvDate.setText(selectedDate);
               }
            }, mYear, mMonth, mDay);

    datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
    datePickerDialog.show();
}