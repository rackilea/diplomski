public void showCustomList() {

    mAllLists = new ArrayList<>();

    mAllLists = mListTableHelper.getAllList();

    final ListData taskList = new ListData();
    taskList.setId(100000000);
    taskList.setTitle("Default List");
    mAllLists.add(0, taskList);


    AlertDialog.Builder builder = new AlertDialog.Builder(AddTaskActivity.this);

    LayoutInflater inflater = getLayoutInflater();
    View convertView = (View) inflater.inflate(R.layout.tablelist, null, false);

    ListView lv = (ListView) convertView.findViewById(R.id.tableslist);

    final ListItemAdapter adapter = new ListItemAdapter(AddTaskActivity.this,mAllLists,selectedItem);

    builder.setAdapter(adapter, null);

    alertDialog = builder.create();

    alertDialog.show();

}