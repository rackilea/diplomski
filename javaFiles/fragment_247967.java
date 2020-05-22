btnDate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            }
        };

        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        final DatePickerDialog datePickerDialog = new DatePickerDialog(
                Main23Activity.this, datePickerListener,
                mYear, mMonth, mDay);
        DatePicker datePicker = datePickerDialog.getDatePicker();

        c.add(Calendar.MONTH, +1);
        long oneMonthAhead = c.getTimeInMillis();
        datePicker.setMaxDate(oneMonthAhead);
        datePicker.setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();

    }
});

btnTime.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {

            }
        };
        Calendar c = Calendar.getInstance();

        final TimePickerDialog timePickerDialog = new TimePickerDialog(Main23Activity.this,timePickerListener,
                c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE)+5,false);
        timePickerDialog.show();

    }
});