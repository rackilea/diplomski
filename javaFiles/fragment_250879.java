private int year;
private int month;
private int day;
private int yearA;
private int monthA;
private int dayA;
private int hour;
private int minute;

static final int DATE_DIALOG_ID = 1;
static final int TIME_DIALOG_ID = 2;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setCurrentDateOnView();
    setCurrentTimeOnView();
    addListenerOnButton();
}

// display current date
public void setCurrentDateOnView() {

    tvDisplayDate = (TextView) findViewById(R.id.tvDate);
    tvDisplayDate2 = (TextView) findViewById(R.id.tvDateA);
    dpResult = (DatePicker) findViewById(R.id.dpResult);

    final Calendar c = Calendar.getInstance();
    year = c.get(Calendar.YEAR);
    month = c.get(Calendar.MONTH);
    day = c.get(Calendar.DAY_OF_MONTH);
    hour = c.get(Calendar.HOUR_OF_DAY);
    minute = c.get(Calendar.MINUTE);

    // set current date into textview
    tvDisplayDate.setText(new StringBuilder()
            // Month is 0 based, just add 1

            .append(day).append("-").append(month + 1).append("-")
            .append(year).append(" "));

    c.add(Calendar.DAY_OF_MONTH, 42);
    dayA = c.get(Calendar.DAY_OF_MONTH);
    monthA = c.get(Calendar.MONTH);
    yearA = c.get(Calendar.YEAR);
    tvDisplayDate2.setText(new StringBuilder()
            // Month is 0 based, just add 1

            .append(dayA).append("-").append(monthA + 1).append("-")
            .append(yearA).append(" "));

    // set current date into datepicker
    dpResult.init(year, month, day, null);

}

// Display current time
public void setCurrentTimeOnView() {
    tvDisplayTime = (TextView) findViewById(R.id.tvTime);
    timepicker = (TimePicker) findViewById(R.id.timepicker);

    // set current time into textview
    tvDisplayTime.setText(new StringBuilder().append(pad(hour)).append(":")
            .append(pad(minute)));

    // set current time into timepicker
    timepicker.setCurrentHour(hour);
    timepicker.setCurrentMinute(minute);

}

public void addListenerOnButton() {

    infringementbutton = (Button) findViewById(R.id.infringementbutton);
    timebutton = (Button) findViewById(R.id.timebutton);

    infringementbutton.setOnClickListener(new View.OnClickListener() {

        @SuppressWarnings("deprecation")
        @Override
        public void onClick(View view) {

            showDialog(DATE_DIALOG_ID);

        }

    });
    timebutton.setOnClickListener(new View.OnClickListener() {

        @SuppressWarnings("deprecation")
        @Override
        public void onClick(View v) {

            showDialog(TIME_DIALOG_ID);

        }
    });
}

protected Dialog onCreateDialog(int id) {

    switch (id) {
    case DATE_DIALOG_ID:
        // set date picker as current date
        return new DatePickerDialog(this, datePickerListener, year, month,
                day);
    case TIME_DIALOG_ID:
        // set time picker as current time
        return new TimePickerDialog(this, timePickerListener, hour, minute,
                false);
    }
    return null;
}

private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

    // when dialog box is closed, below method will be called.
    public void onDateSet(DatePicker view, int selectedYear,
            int selectedMonth, int selectedDay) {
        year = selectedYear;
        month = selectedMonth;
        day = selectedDay;

        // set selected date into textview
        tvDisplayDate.setText(new StringBuilder().append(day).append("-")
                .append(month + 1).append("-").append(year).append(" "));

        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        c.add(Calendar.DAY_OF_MONTH, 42);
        dayA = c.get(Calendar.DAY_OF_MONTH);
        monthA = c.get(Calendar.MONTH);
        yearA = c.get(Calendar.YEAR);

        tvDisplayDate2.setText(new StringBuilder().append(dayA).append("-")
                .append(monthA + 1).append("-").append(yearA).append(" "));

        // set selected date into datepicker also
        dpResult.init(year, month, day, null);

    }

};
private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
    public void onTimeSet(TimePicker view, int selectedHour,
            int selectedMinute) {
        hour = selectedHour;
        minute = selectedMinute;

        // set current time into textview
        tvDisplayTime.setText(new StringBuilder().append(pad(hour))
                .append(":").append(pad(minute)));

        // set current time into timepicker
        timepicker.setCurrentHour(hour);
        timepicker.setCurrentMinute(minute);

    }
};

private static String pad(int c) {
    if (c >= 10)
        return String.valueOf(c);
    else
        return "0" + String.valueOf(c);
}