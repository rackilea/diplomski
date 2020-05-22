import java.util.ArrayList;
import library.DatabaseHandler;
import org.json.JSONObject;
import com.actionbarsherlock.R;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class Polling extends SherlockFragmentActivity {
    private ViewPager mViewPager;
    private TabsAdapter mTabsAdapter;
    private final static String TAG = "21st Polling:";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.pager);
        setContentView(mViewPager);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        bar.setDisplayShowTitleEnabled(false);
        bar.setDisplayShowHomeEnabled(false);

        mTabsAdapter = new TabsAdapter(this, mViewPager);
        mTabsAdapter.addTab(bar.newTab().setText(R.string.login),
                LoginFragment.class, null);
        mTabsAdapter.addTab(bar.newTab().setText(R.string.economics),
                EconFragment.class, null);
        mTabsAdapter.addTab(bar.newTab().setText(R.string.elections),
                ElectionsFragment.class, null);
        mTabsAdapter.addTab(bar.newTab().setText(R.string.politics),
                PoliticsFragment.class, null);
        mTabsAdapter.addTab(bar.newTab().setText(R.string.science),
                ScienceFragment.class, null);
        mTabsAdapter.addTab(bar.newTab().setText(R.string.finance),
                FinanceFragment.class, null);
        mTabsAdapter.addTab(bar.newTab().setText(R.string.religion),
                ReligionFragment.class, null);
        mTabsAdapter.addTab(bar.newTab().setText(R.string.military),
                MilitaryFragment.class, null);
        mTabsAdapter.addTab(bar.newTab().setText(R.string.international),
                InternationalFragment.class, null); 
        Log.v(TAG, (String)bar.getTabAt(0).getText());

    }
public static class TabsAdapter extends FragmentPagerAdapter
    implements ActionBar.TabListener, ViewPager.OnPageChangeListener {
        private final Context mContext;
        private final ActionBar mActionBar;
        private final ViewPager mViewPager;
        private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

        static final class TabInfo {
            private final Class<?> clss;
            private final Bundle args;

            TabInfo(Class<?> _class, Bundle _args) {
                clss = _class;
                args = _args;
            }
        }

        public TabsAdapter(SherlockFragmentActivity activity, ViewPager pager) {
            super(activity.getSupportFragmentManager());
            mContext = activity;
            mActionBar = activity.getSupportActionBar();
            mViewPager = pager;
            mViewPager.setAdapter(this);
            mViewPager.setOnPageChangeListener(this);
        }

        public void addTab(ActionBar.Tab tab, Class<?> clss, Bundle args) {
            TabInfo info = new TabInfo(clss, args);
            tab.setTag(info);
            tab.setTabListener(this);
            mTabs.add(info);
            mActionBar.addTab(tab);
            notifyDataSetChanged();
        }


        public int getCount() {
            return mTabs.size();
        }

        public SherlockFragment getItem(int position) {
            TabInfo info = mTabs.get(position);
            return (SherlockFragment)Fragment.instantiate(mContext, info.clss.getName(), info.args);
        }


        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }


        public void onPageSelected(int position) {
            mActionBar.setSelectedNavigationItem(position);
        }


        public void onPageScrollStateChanged(int state) {
        }


        public void onTabSelected(Tab tab, FragmentTransaction ft) {
            mViewPager.setCurrentItem(tab.getPosition());
            //Log.v(TAG, "clicked");
            Object tag = tab.getTag();
            for (int i=0; i<mTabs.size(); i++) {
                if (mTabs.get(i) == tag) {
                    mViewPager.setCurrentItem(i);
                }
            }
        }

        public void onTabUnselected(Tab tab, FragmentTransaction ft) {}

        public void onTabReselected(Tab tab, FragmentTransaction ft) {}

        public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {}

        public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {}
    }