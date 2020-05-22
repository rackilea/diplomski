public class WorkoutActivity extends Activity {

WorkoutItemAdapter workoutItemAdapter;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_workout);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.workout, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
        return true;
    }
    return super.onOptionsItemSelected(item);
}

@Override
public void onBackPressed() {
    moveTaskToBack(true);
}

public List<WorkoutItem> getDataForListView() {
    SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(this);
    String workoutTime = prefs.getString("Workout Time", "");

    List<WorkoutItem> workoutsList = new ArrayList<WorkoutItem>();

    for (int i = 0; i < (10+ 1); i++) {
        WorkoutItem workout = new WorkoutItem();
        workout.workoutNum = "Workout " + (i + 1);
        workout.time = workoutTime;

        workoutsList.add(workout);
    }

    return workoutsList;
}

public void startAndStopTimer(View view) {
    long totalTime = 0;

    Button startAndStop = (Button) findViewById(R.id.button1);
    Chronometer c = (Chronometer) findViewById(R.id.chronometer1);
    if (startAndStop.getText().equals("Start")) {
        c.setBase(SystemClock.elapsedRealtime() + totalTime);
        c.start();
        startAndStop.setText("Pause");

    } else {
        totalTime = c.getBase() - SystemClock.elapsedRealtime();
        c.stop();
        startAndStop.setText("Start");
    }
}

public void save(View view) {
    // create broadcast receiver saying ...saved.

    // Add ArrayList value to arrayList
    Chronometer timer = (Chronometer) findViewById(R.id.chronometer1);

    SharedPreferences timerSettings = PreferenceManager
            .getDefaultSharedPreferences(this);
    Editor editor = timerSettings.edit();
    editor.putString("Workout Time", timer.getText().toString());
    editor.commit();

    // go back to main activity.
    Intent intent = new Intent(WorkoutActivity.this, OverviewActivity.class);
    intent.putStringArrayListExtra("stock_list", getDataForListView());
    startActivity(intent);
    finish();
}

public void cancel(View view) {
    // go back to main activity
    Intent intent = new Intent(WorkoutActivity.this, OverviewActivity.class);
    intent.putStringArrayListExtra("stock_list", getDataForListView());
    startActivity(intent);

    finish();
}

}