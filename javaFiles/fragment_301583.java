public class MainActivity extends AppCompatActivity implements OnTaskCompleted {

  @Override
  public void onTaskCompleted(List<ParseObject> response) {

  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    new FetchParseQueryTask(MainActivity.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new PagingOptions(0, 200));
    new FetchParseQueryTask(MainActivity.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new PagingOptions(1, 200));
    new FetchParseQueryTask(MainActivity.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new PagingOptions(2, 200));
  }
}