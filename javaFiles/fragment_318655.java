public MyActivity extends Activity {
    private MenuHandler menuHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        menuHandler = new MenuHandler(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return menuHandler.onCreateOprionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return menuHandler.onOptionsItemSelected(item);
    }
}