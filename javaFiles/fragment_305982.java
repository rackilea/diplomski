class BaseActivity extends Activity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MenuHelper.handleOnItemSelected(item);
    }
}