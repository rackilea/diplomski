public Dialog onCreateDialog(Bundle savedInstanceState) {
    final Calendar calendar = Calendar.getInstance();
    int yy = calendar.get(Calendar.YEAR);
    int mm = calendar.get(Calendar.MONTH);
    int dd = calendar.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog datePicker = new DatePickerDialog(getActivity(), this,
            yy, mm, dd);
    datePicker.getDatePicker().setCalendarViewShown(false);
    // Set calendar to 1 day next from today
    calendar.add(Calendar.DAY_OF_MONTH, 1);
    // Set calendar to 1 month next
    calendar.add(Calendar.MONTH, 1);
    datePicker.getDatePicker().setMaxDate(calendar.getTimeInMillis());

    datePicker.setTitle("RENTRE TA DATE DE NAISSANCE.");

    return datePicker;
}