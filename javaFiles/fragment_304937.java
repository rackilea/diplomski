private MyAsyncTask task;

@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    int time;
    // Some methodology to get the desired time
    createButton(time);
    new MyAsyncTask().execute(time -1);
}