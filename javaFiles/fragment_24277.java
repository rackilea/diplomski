private DatePickerDialog.OnDateSetListener dpickerListener
        = new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        year_x = year;
        month_x = month;
        day_x = dayOfMonth;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year_x, month_x, day_x);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        textView.setText(currentDateString);

    }
};