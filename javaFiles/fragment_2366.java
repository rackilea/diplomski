// field in see_schedule_activity
private ArrayAdapter<String> adapter;

// which you'll initialize in onCreate()
// with an empty list, as you don't yet have the data
...
adapter = new ArrayAdapter<String>(this,
            R.layout.activity_listview, new ArrayList<>());

ListView listView = (ListView) findViewById(R.id.schedulelist);
listView.setAdapter(adapter); 
... rest of onCreate()

public void update(List<String> results) {
    adapter.clear();
    adapter.addAll(results);
}