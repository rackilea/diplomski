public class OverviewActivity extends Activity{ 


List<WorkoutItem> workList;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_overview);
    Intent i = getIntent();  
    workList = i.getStringArrayListExtra("stock_list");
    LoadPreferences();  
    LoadListView();
}
private void LoadListView() {
    // TODO Auto-generated method stub
    ListView workoutList = (ListView) findViewById(R.id.workout_list);

    WorkoutItemAdapter workoutAdapter= new WorkoutItemAdapter(workList);
    workoutList.setAdapter(workoutAdapter);
}


@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.overview, menu);
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

private void LoadPreferences()
{       
        SharedPreferences sharedPreferences =     PreferenceManager.getDefaultSharedPreferences(this);
        String Name = sharedPreferences.getString("Name", "");

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(Name);
}

public void openWorkoutActivity(View view)
{
    Intent intent = new Intent(OverviewActivity.this, WorkoutActivity.class);
    startActivity(intent);
    finish();
}
public void openProfileActivity(View view)
{
    Intent intent = new Intent(OverviewActivity.this, ProfileActivity.class);
    startActivity(intent);
    finish();
}
public void openHistoryActivity(View view)
{
    Intent intent = new Intent(OverviewActivity.this, HistoryActivity.class);
    startActivity(intent);
    finish();
}

public class WorkoutItemAdapter extends BaseAdapter{

    int rowCount = 1;
    List<WorkoutItem> workoutsList ;

  public  WorkoutItemAdapter( List<WorkoutItem> list) {
  workoutsList=list;
}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) WorkoutActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.workout_item, parent, false);
        }

        TextView workoutNum = (TextView) convertView.findViewById(R.id.workout_col);
        TextView workoutTime = (TextView) convertView.findViewById(R.id.time_col);      

        WorkoutItem workout = workoutsList.get(position);

        workoutNum.setText(workout.workoutNum);
        workoutTime.setText(workout.time);

        return convertView;
    }

    @Override
    public int getCount() {
        return workoutsList.size();
        // TODO Auto-generated method stub
    }

    @Override
    public WorkoutItem getItem(int position) {
        // TODO Auto-generated method stub
        return workoutsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    public void addRow() {
        rowCount++;
        notifyDataSetChanged();
    }
}
}