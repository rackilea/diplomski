public class MyActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuHelper.build(menu);

        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        super.onMenuItemSelected(featureId, item);

        return MenuHelper.onMenuItemSelected(featureId, item, this);
    }

}