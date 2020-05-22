package com.ciudad2020.medioambiente2020;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import java.util.HashMap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends ActionBarActivity implements
    TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

private FragmentPagerAdapter mAdapter;
private TabHost mTabHost;
private ViewPager mPager;
private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, Search.TabInfo>();
public User us;
private int page;


@Override
public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    // View v=findViewById(R.layout.pager);







    Log.e("Tipo de usuario", AppManager.getInstance().getUser().getUserType());
    Log.e("ESNULL",Boolean.toString(AppManager.getInstance().getSharedPreferences(AppManager.getInstance().getUser().getId(), Context.MODE_PRIVATE)==null));


    setContentView(R.layout.pager);
    us = AppManager.getInstance().getUser();

    this.initialiseTabHost(savedInstanceState);

    if (savedInstanceState != null) {
        mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
    }
    // Intialise ViewPager
    this.intialiseViewPager();

    Intent intent = getIntent();

    page = intent.getIntExtra("page", 0);

    this.mTabHost.setCurrentTab(page);
    this.mPager.setCurrentItem(page);


    for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
        View v = mTabHost.getTabWidget().getChildAt(i);


        TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
        tv.setTextColor(getResources().getColor(R.color.white));
    }

    // args.putString("id", id);;
    // us.loadFromDb();

}

@Override
public void onBackPressed() {
    Log.d("CDA", "onBackPressed Called");
    Intent setIntent = new Intent(Intent.ACTION_MAIN);
    setIntent.addCategory(Intent.CATEGORY_HOME);
    setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(setIntent);
}



protected void onSaveInstanceState(Bundle outState) {
    outState.putString("tab", mTabHost.getCurrentTabTag()); // save the tab
                                                            // selected
    super.onSaveInstanceState(outState);
}

/**
 * Initialise ViewPager
 */
private void intialiseViewPager() {

    if (us.getUserType().equals("REGISTERED")) {

    this.mAdapter = new PagerAdapter(super.getSupportFragmentManager());
    //
    }

    else{

        this.mAdapter = new ViewerPagerAdapter(super.getSupportFragmentManager());

    }

    this.mPager = (ViewPager) super.findViewById(R.id.pagerr);
    this.mPager.setPageMargin(20);
    this.mPager.setPadding(0, 0, 0, 0);

    this.mPager.setAdapter(this.mAdapter);
    this.mPager.setOnPageChangeListener(this);
}

private void initialiseTabHost(Bundle args) {

    mTabHost = (TabHost) findViewById(android.R.id.tabhost);
    mTabHost.setup();
    TabInfo tabInfo;

    Search.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab1")
            .setIndicator("Información"), (tabInfo = new TabInfo(
            "Tab1", InfoFragment.class, args)));
    this.mapTabInfo.put(tabInfo.tag, tabInfo);

    Search.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab3")
            .setIndicator("Alertas"), (tabInfo = new TabInfo("Tab3",
            WarningsFragment.class, args)));
    this.mapTabInfo.put(tabInfo.tag, tabInfo);


    // Default to first tab
    // this.onTabChanged("Tab1");
    //
    mTabHost.setOnTabChangedListener(this);
}

/**
 * Add Tab content to the Tabhost
 * 
 * @param activity
 * @param tabHost
 * @param tabSpec
 */
private static void AddTab(Search activity, TabHost tabHost,
        TabHost.TabSpec tabSpec, TabInfo tabInfo) {
    // Attach a Tab view factory to the spec
    tabSpec.setContent(activity.new TabFactory(activity));
    tabHost.addTab(tabSpec);
}

public void muestraTostada(String cartel) {
    Toast.makeText(this, cartel, Toast.LENGTH_LONG).show();
}


public static class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public float getPageWidth(int position) {

        return (1f);

    }

    @Override
    public Fragment getItem(int position) {

        InfoFragment iF = new InfoFragment();
        WarningsFragment wF = new WarningsFragment();
        Bundle args = new Bundle();
        args.putInt("number", position);

        switch (position) {
        case 0:

            return iF;
        case 1:
            return wF;

        default:
            return null;
        }
    }
}

public static class ViewerPagerAdapter extends FragmentPagerAdapter {

    public ViewerPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public float getPageWidth(int position) {

        return (1f);

    }

    @Override
    public Fragment getItem(int position) {

        InfoFragment iF = new InfoFragment();
        WarningsFragment wF = new WarningsFragment();
        Bundle args = new Bundle();
        args.putInt("number", position);

        switch (position) {
        case 0:
            return iF;

        case 1:
            return wF;

        case 2:
                return wF;

        default:
            return null;
        }
    }
}

@Override
public void onPageScrollStateChanged(int arg0) {

}

@Override
public void onPageScrolled(int arg0, float arg1, int arg2) {
    int pos = this.mPager.getCurrentItem();
    this.mTabHost.setCurrentTab(pos);

}

@Override
public void onPageSelected(int arg0) {


}

@Override
public void onTabChanged(String arg0) {
    int pos = this.mTabHost.getCurrentTab();
    this.mPager.setCurrentItem(pos);
}

/**
 * 
 * @author cbg Maintains extrinsic info of a tab's construct
 */

private class TabInfo {
    private String tag;
    private Class<?> clss;
    private Bundle args;
    private Fragment fragment;

    TabInfo(String tag, Class<?> clazz, Bundle args) {
        this.tag = tag;
        this.clss = clazz;
        this.args = args;
    }
}

class TabFactory implements TabContentFactory {

    private final Context mContext;

    /**
     * @param context
     */
    public TabFactory(Context context) {
        mContext = context;
    }

    /**
     * (non-Javadoc)
     * 
     * @see android.widget.TabHost.TabContentFactory#createTabContent(java.lang.String)
     */
    public View createTabContent(String tag) {
        View v = new View(mContext);
        v.setMinimumWidth(0);
        v.setMinimumHeight(0);
        return v;
    }

}



@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu items for use in the action bar
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main, menu);
    return super.onCreateOptionsMenu(menu);
}



@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle presses on the action bar items
    int itemId = item.getItemId();
    switch (itemId) {

        case R.id.action_edit:
            showEditDialog();

            // Toast.makeText(this, "home pressed", Toast.LENGTH_LONG).show();
            break;

        case R.id.action_warnings:
            showEditWarningsDialog();

    }

    return true;
}

public void showEditDialog() {


    android.app.FragmentManager fm = getFragmentManager();
    EditDialog editNameDialog = new EditDialog();
    editNameDialog.show(fm, "fragment_edit_name");
}


public void showEditWarningsDialog(){

    android.app.FragmentManager fm = getFragmentManager();
    EditWarningsDialog editWarningsDialog = new EditWarningsDialog();
    editWarningsDialog.show(fm, "fragment_edit_warning");


}


}