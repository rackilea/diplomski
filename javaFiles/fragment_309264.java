private void showDatePicker(){
   DatePickerDialog datePickerDialog = new DatePickerDialog(
   getActivity(), this, calendar.get(Calendar.YEAR),  calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
   //this is where the crash happens
   datePickerDialog.getDatePicker().setMinDate(new Date().getTime() - 10000);
   datePickerDialog.show();