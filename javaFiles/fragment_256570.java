public class BaseActivity extends FragmentActivity {

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
            //Removed the AddJournalEntry before this
        actionbarcolor = PreferenceData.getIntValues(this,
                "actionbarcolor");
        if (actionbarcolor == 1) {
            ActionBar actionBar = getActionBar();
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLUE));
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
        } else if (actionbarcolor == 2) {
            ActionBar actionBar = getActionBar();
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
        }
    }

}