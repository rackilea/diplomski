public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        int i = preferences.getInt("numberoflaunches", 1);

        if (i < 2) {
            alarmMethod();
            i++;
            editor.putInt("numberoflaunches", i);
            editor.commit();
        }
    }

    private void alarmMethod() {

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
                new Intent("com.example.application.myNotification"),
                PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmMgr = (AlarmManager) (this
                .getSystemService(Context.ALARM_SERVICE));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.HOUR_OF_DAY, 6);

        long mills = calendar.getTimeInMillis();
        if (mills <= System.currentTimeMillis()) {
            Calendar c1 = calendar;
            c1.add(Calendar.DAY_OF_MONTH, 1);
            mills = c1.getTimeInMillis();
        } else {
            mills = calendar.getTimeInMillis();
        }

        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, mills,
                1000 * 60 * 60 * 24, pendingIntent);

        Toast.makeText(MainActivity.this, "Alarm Set", Toast.LENGTH_SHORT)
                .show();

    }

}