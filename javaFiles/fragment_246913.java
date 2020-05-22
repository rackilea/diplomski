public class MainActivity extends ActionBarActivity {
private Adapter myAdapter;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    myAdapter = new Adapter();
    ListView listView = (ListView)findViewById(android.R.id.list);
    listView.setAdapter(myAdapter);
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

    if (id == R.id.action_add_task){
        Intent i =  new Intent(this,AddTaskActivity.class);
        startActivityForResult(i, 1);
    }

    return super.onOptionsItemSelected(item);
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data){
    if(requestCode == 1){
        if(resultCode == RESULT_OK){
            myAdapter.addTask(data.getParcelableExtra(AddTaskActivity.[key constant]));

        } else {
            //DO SOMETHING IF NO INFO IS RETURNED
        }
    }
}

public void TaskClicked(){

}

private class Adapter extends BaseAdapter {

    private List<Task> myTasks;

    public Adapter() {
        myTasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        myTasks.add(task);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return myTasks.size();
    }

    @Override
    public Object getItem(int position) {
        return myTasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tw = (TextView)findViewById(R.id.addMainHint);
        ((ViewManager) tw.getParent()).removeView(tw);

        convertView = getViewNotNull(convertView, parent);

        Task task = (Task)getItem(position);

        TextView taskName = (TextView) convertView.findViewById(R.id.single_task_info);
        taskName.setText(task.getTask());
    }

    private View getViewNotNull(View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.task_listing)

            //here you should create a viewholder and set it on the view using setTag()
        }
        return convertView;
    }
}

}