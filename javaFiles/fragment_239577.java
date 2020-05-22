@Override
public void onCreate (Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    ...
    ...
    listView = (ListView) findViewById(R.id.listView1);
    registerForContextMenu(listView);
}