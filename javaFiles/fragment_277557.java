import android.support.v7.app.ActionBar

public class YourActivity extends ActionBarActivity {
ActionBar actionBar;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    actionBar = getSupportActionBar(); // now do whatever you want to do with this action bar
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}

    @Override
public boolean onOptionsItemSelected(MenuItem item) {

switch (item.getItemId()) {
    case android.R.id.home:
        // code for your action when you click home icon on action bar
        break;

    default:
        break;
    }

return true;
}


}