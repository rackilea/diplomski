class BaseMapActivity extends MapActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MenuHelper.handleOnItemSelected(item);
    }
}