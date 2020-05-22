public class MainActivity extends AppCompatActivity {


public static int alarmHour, alarmMin, alarmDay, alarmYear, alarmMonth;
final static int RQS_1 = 1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
        return true;
    }

    return super.onOptionsItemSelected(item);
}

public void setDate(View view) {
    DialogFragment newFragment = new DatePickerFragment();
    newFragment.show(getSupportFragmentManager(), "datePicker");
}

public void setTime(View view) {

    DialogFragment newFragment = new TimePickerFragment();
    newFragment.show(getSupportFragmentManager(), "timePicker");
}


public void setAlarm(View view) {
    Calendar calNow = Calendar.getInstance();
    Calendar calSet = (Calendar) calNow.clone();
    calSet.set(Calendar.HOUR_OF_DAY, alarmHour);
    calSet.set(Calendar.MINUTE, alarmMin);
    calSet.set(Calendar.DAY_OF_MONTH, alarmDay);
    calSet.set(Calendar.YEAR, alarmYear);
    calSet.set(Calendar.MONTH, alarmMonth);

    setAlarmN(calSet);
}

private void setAlarmN(Calendar targetCal) {

    Toast.makeText(this, "Alarm is set at" + targetCal.getTime(),
            Toast.LENGTH_LONG).show();
    Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(
            getBaseContext(), RQS_1, intent, 0);
    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
            pendingIntent);

}

//date picker fragment
public static class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        alarmDay = day;
        alarmYear = year;
        alarmMonth = month;
    }
}

//Time picker fragment 
public static class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        alarmHour = hourOfDay;
        alarmMin = minute;
    }
}


}