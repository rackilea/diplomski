private ArrayList<TaskObjects> tasksArray = new ArrayList<>();


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);

for(int i=0; i < 10; i++){
TaskObjects task=  new TaskObjects("Title " + i, "Category " + i, "Description " + i, i + 10);
tasksArray.add(task);
  Log.d("For Loop", "" + i);
}

}