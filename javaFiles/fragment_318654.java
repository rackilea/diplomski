public class MenuHandler {
    private Activity activity;

    public MenuHandler(Activity activity) {
        this.activity = activity;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = activity.getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle events here
    }
}