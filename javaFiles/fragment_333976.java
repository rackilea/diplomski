public class CalendarActivity extends AppCompatActivity {

    private static final int REQUEST_CREATE_EVENT = 0;

    CalendarView calendar;
    Button createEvent;
    public static String createEventDate;
    TextView eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        eventList = (TextView) findViewById(R.id.eventList);

        getEvents();

        calendar = (CalendarView) findViewById(R.id.calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                createEventDate = (month + "." + dayOfMonth + "." + year);
                createEvent.setText("Create Event for " + createEventDate);
            }
        });

        createEvent = (Button) findViewById(R.id.eventCreateButton);
        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toEventCreateActivity = new Intent(CalendarActivity.this, EventCreateActivity.class);
                startActivityForResult(toEventCreateActivity, REQUEST_CREATE_EVENT);
            }
        });
    }

    private void getEvents() {
        // getting our DatabaseHelper instance
        DatabaseHelper db = DatabaseHelper.getInstance(this);

        Cursor result = db.getAllData();
        if (result.getCount() == 0) {
            noEventToday();
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            while (result.moveToNext()) {
                stringBuffer.append("eventDat : " + result.getString(0) + "\n");
                stringBuffer.append("timeHour : " + result.getString(1) + "\n");
                stringBuffer.append("timeMinue : " + result.getString(2) + "\n");
                stringBuffer.append("event : " + result.getString(3) + "\n");
                stringBuffer.append("location : " + result.getString(4) + "\n");
                stringBuffer.append("crew : " + result.getString(5) + "\n\n");
                eventList.setText(stringBuffer);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == REQUEST_CREATE_EVENT) {
            getEvents();
        }
    }

    public void noEventToday(){
        TextView eventList = (TextView)findViewById(R.id.eventList);
        eventList.setText("Nothing scheduled for today.");
    }
}