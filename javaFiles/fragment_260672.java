public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this is your old code which will crash the app
        //TestVolley tester = new TestVolley();
        //tester.fetchModules(this);

        // Works!
        new MyVolleyAsyncTask(this).execute();
    }
}