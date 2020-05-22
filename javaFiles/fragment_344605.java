@Override
protected void onCreate(Bundle savedInstanceState) {
    Date date = null;
    CalendarView v = new CalendarView( this );
    v.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
        public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
            date = new Date(year, month, dayOfMonth);
        }
    });
    Intent intent = new Intent(this, AnotherActivity.class);
    intent.putExtra("long date", date.getTime());       
    startActivity(intent);
}