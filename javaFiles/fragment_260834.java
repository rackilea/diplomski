import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.content.res.Resources;
import android.util.Log;
import android.support.v4.widget.DrawerLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import android.widget.ListView;
import android.widget.FrameLayout;
import android.widget.SimpleExpandableListAdapter;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;

public class MainActivity extends ActionBarActivity {

  private String TAG = "MainActivity";

  private Activity mActivity;
  private DrawerLayout mDrawerLayout;
  private ListView mListView;
  private String[] mItems;
  private ActionBarDrawerToggle mActionBarDrawerToggle;

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);

    setContentView(R.layout.activity_main);

    Log.d(TAG, "onCreate");

    mActivity = this;

    mItems = new String[]{"one", "two", "three"};
    mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
    mListView = (ListView)findViewById(R.id.drawer_list);
    mListView.setAdapter(new ArrayAdapter(mActivity, android.R.layout.simple_list_item_1, android.R.id.text1, mItems));
    mActionBarDrawerToggle = new ActionBarDrawerToggle(mActivity, mDrawerLayout, R.string.drawer_open, R.string.drawer_close){
      @Override
      public void onDrawerClosed(View view) {
        super.onDrawerClosed(view);
        getSupportActionBar().setTitle("onDrawerClosed");
        invalidateOptionsMenu();
        syncState();
      }

      @Override
      public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);
        getSupportActionBar().setTitle("onDrawerOpened");
        invalidateOptionsMenu();
        syncState();
      }
    };
    mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
    mActionBarDrawerToggle.syncState();
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    mActionBarDrawerToggle.syncState();
  }
}