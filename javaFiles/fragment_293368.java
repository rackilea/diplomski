public class SignUpSecondActivity extends AppCompatActivity {
private LayoutInflater layoutInflater;
private EditText txtFrom, txtTo;
private Calendar calendar;
private TimePickerDialog timepickerdialog;
private int CalendarHour, CalendarMinute;
private String format;
private TextView txtClubTime,txtFromSunday,txtToSunday,txtFromMonday,txtToMonday;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up_second);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    initView();
    getTxtFromSunday().setOnClickListener(view -> getClubTiming(txtClubTime));
}

private void initView() {
    txtClubTime = (TextView) findViewById(R.id.txtClubTime);
    txtFromSunday = (TextView) findViewById(R.id.txtFromSunday);
    txtToSunday = (TextView) findViewById(R.id.txtToSunday);
    txtFromMonday = (TextView) findViewById(R.id.txtFromMonday);
    txtToMonday = (TextView) findViewById(R.id.txtToMonday);
}

private void getClubTiming(TextView txtClubTime) {

    TextView txtClub = txtClubTime;
    calendar = Calendar.getInstance();
    CalendarHour = calendar.get(Calendar.HOUR_OF_DAY);
    CalendarMinute = calendar.get(Calendar.MINUTE);
    timepickerdialog = new TimePickerDialog(this,
            (view, hourOfDay, minute) -> {
                if (hourOfDay == 0) {
                    hourOfDay += 12;
                    format = "am";
                } else if (hourOfDay == 12) {
                    format = "pm";
                } else if (hourOfDay > 12) {
                    hourOfDay -= 12;
                    format = "pm";
                } else {
                    format = "am";
                }
                Log.i("@sandy","ClubTiming: "+txtClub);
                if (txtClub!=null){
                    txtClub.setText(String.format("%02d:%02d" + format, hourOfDay, minute));
                    Log.i("@sandy","ClubTiming- "+txtClub);
                }

                Log.i("@sandy", "Time: " + String.format("%02d:%02d" + format, hourOfDay, minute));
            }, CalendarHour, CalendarMinute, false);
    timepickerdialog.show();
}

}