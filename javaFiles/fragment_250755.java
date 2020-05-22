DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String selectedDate = dateFormat.format(calendar.getTime());

        btnDate.setText(selectedDate);
        btnDate.setTextColor(getResources().getColor(colorPrimaryDark));
    }
};