CalendarView calendar;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_calender);


    calendar = (CalendarView) findViewById(R.id.calendarView);
    calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener()  {

        @Override
        public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
            Toast.makeText(getApplicationContext(), dayOfMonth+ "/" + month + "/" + year, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Calender.this, AddDeadline.class)
             intent.putExtra("date", dayOfMonth+ "/" + month + "/" + year);
            startActivity(intent);
        }

    });
}