public class MainActivity extends AppCompatActivity {

    AppDatabase roomDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roomDB = AppDatabase.getAppDatabase(getApplicationContext());
        new Thread(new Runnable() {
            @Override
            public void run() {
                Task task = roomDB.taskDAO().getTaskById(0); //task is null
                List<Task> alltasks = roomDB.taskDAO().getAll();
                for (Task t: alltasks) {
                    Log.d("TASKINFO","Task =" + t.getDescription() + " ID = " + t.getTaskId());
                }
            }
        }).start();
    }
}