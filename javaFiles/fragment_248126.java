@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.R.layout.activity_main);

    new Handler().postDelayed(new Runnable()
    {
        @Override
        public void run()
        {
            Intent goForward = new Intent(MainActivity.this, CampusSelect.class);
            startActivity(goForward);
        }
    }, 5000);
}