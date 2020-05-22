package com.broken.keyboard;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.content.Context;

public class KeyboardTestActivity extends Activity {

    /**
     * This class wraps the addition of tabs to the ActionBar,
     * while properly swapping between them.  Furthermore, it
     * also provides a listener interface by which you can
     * react additionally to the tab changes.  Lastly, it also
     * provides a callback for after a tab has been changed and
     * a runnable has been post to the View hierarchy, ensuring
     * the fragment transactions have completed.  This allows
     * proper timing of a call to requestFocus(), and other
     * similar methods.
     * 
     * @author nacitar sevaht
     *
     */
    public static class ActionBarTabManager 
    {
        public static interface TabChangeListener
        {
            /**
             * Invoked when a new tab is selected.
             * 
             * @param tag The tag of this tab's fragment.
             */
            public abstract void onTabSelected(String tag);

            /**
             * Invoked when a new tab is selected, but after
             * a Runnable has been executed after being post
             * to the view hierarchy, ensuring the fragment
             * transaction is complete.
             * 
             * @param tag The tag of this tab's fragment.
             */
            public abstract void onTabSelectedPost(String tag);

            /**
             * Invoked when the currently selected tab is reselected.
             * 
             * @param tag The tag of this tab's fragment.
             */
            public abstract void onTabReselected(String tag);

            /**
             * Invoked when a new tab is selected, prior to {@link onTabSelected}
             * notifying that the previously selected tab (if any) that it is no
             * longer selected.
             * 
             * @param tag The tag of this tab's fragment.
             */
            public abstract void onTabUnselected(String tag);


        }

        // Variables
        Activity mActivity = null;
        ActionBar mActionBar = null;
        FragmentManager mFragmentManager = null;
        TabChangeListener mListener=null;
        View mContainer = null;
        Runnable mTabSelectedPostRunnable = null;

        /**
         * The constructor of this class.
         * 
         * @param activity The activity on which we will be placing the actionbar tabs.
         * @param containerId The layout id of the container, preferable a  {@link FrameLayout}
         *        that will contain the fragments.
         * @param listener A listener with which one can react to tab change events.
         */
        public ActionBarTabManager(Activity activity, int containerId, TabChangeListener listener)
        {
            mActivity = activity;
            if (mActivity == null)
                throw new RuntimeException("ActionBarTabManager requires a valid activity!");

            mActionBar = mActivity.getActionBar();
            if (mActionBar == null)
                throw new RuntimeException("ActionBarTabManager requires an activity with an ActionBar.");

            mContainer = activity.findViewById(containerId);

            if (mContainer == null)
                throw new RuntimeException("ActionBarTabManager requires a valid container (FrameLayout, preferably).");

            mListener = listener;
            mFragmentManager = mActivity.getFragmentManager();

            // Force tab navigation mode
            mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        }

        /**
         * Simple Runnable to invoke the {@link onTabSelectedPost} method of the listener.
         * 
         * @author nacitar sevaht
         *
         */
        private class TabSelectedPostRunnable implements Runnable
        {
            String mTag = null;
            public TabSelectedPostRunnable(String tag)
            {
                mTag=tag;
            }
            @Override
            public void run() {
                if (mListener != null) {
                    mListener.onTabSelectedPost(mTag);
                }
            }

        }

        /**
         * Internal TabListener.  This class serves as a good example
         * of how to properly handles swapping the tabs out.  It also
         * invokes the user's listener after swapping.
         * 
         * @author nacitar sevaht
         *
         */
        private class TabListener implements ActionBar.TabListener
        {
            private Fragment mFragment=null;
            private String mTag=null;
            public TabListener(Fragment fragment, String tag)
            {
                mFragment=fragment;
                mTag=tag;
            }
            private boolean post(Runnable runnable)
            {
                return mContainer.post(runnable);
            }
            @Override
            public void onTabReselected(Tab tab, FragmentTransaction ft) {
                // no fragment swapping logic necessary

                if (mListener != null) {
                    mListener.onTabReselected(mTag);
                }

            }
            @Override
            public void onTabSelected(Tab tab, FragmentTransaction ft) {
                mFragmentManager.beginTransaction()
                    .replace(mContainer.getId(), mFragment, mTag)
                    .commit();
                if (mListener != null) {
                    mListener.onTabSelected(mTag);
                }
                // Post a runnable for this tab
                post(new TabSelectedPostRunnable(mTag));
            }

            @Override
            public void onTabUnselected(Tab tab, FragmentTransaction ft) {
                mFragmentManager.beginTransaction()
                    .remove(mFragment)
                    .commit();
                if (mListener != null) {
                    mListener.onTabUnselected(mTag);
                }
            }

        }

        /**
         * Simple wrapper for adding a text-only tab.  More robust
         * approaches could be added.
         * 
         * @param title The text to display on the tab.
         * @param fragment The fragment to swap in when this tab is selected.
         * @param tag The unique tag for this tab.
         */
        public void addTab(String title, Fragment fragment, String tag)
        {
            // The tab listener is crucial here.
            mActionBar.addTab(mActionBar.newTab()
                    .setText(title)
                    .setTabListener(new TabListener(fragment, tag)));   
        }

    }
    /**
     * A simple custom view that toggles the on screen keyboard when touched,
     * and also prints a log message whenever a key event is received.
     * 
     * @author nacitar sevaht
     *
     */
    public static class MyView extends View {
        public void toggleKeyboard()
        { ((InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(0, 0); }

        public MyView(Context context)
        { super(context); }

        public MyView(Context context, AttributeSet attrs)
        { super(context, attrs); }

        public MyView(Context context, AttributeSet attrs, int defStyle)
        { super(context, attrs, defStyle); }


        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            Log.i("BDBG", "Key (" + keyCode + ") went down in the custom view!");
            return true;
        }

        // Toggle keyboard on touch!
        @Override
        public boolean onTouchEvent(MotionEvent event)
        {
            if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN)
            {
                toggleKeyboard();
            }
            return super.onTouchEvent(event);
        }
    }

    // Extremely simple fragment
    public class MyFragment extends Fragment {
        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.my_fragment, container, false);
            return v;
        }
    }

    public class MyTabChangeListener implements ActionBarTabManager.TabChangeListener
    {
        public void onTabReselected(String tag) { }
        public void onTabSelected(String tag) { }
        public void onTabSelectedPost(String tag)
        {
            // TODO: NOTE: typically, one would conditionally set the focus based upon the tag.
            //             but in our sample, both tabs have the same fragment layout.
            View view=findViewById(R.id.myview);
            if (view == null)
            {
                throw new RuntimeException("Tab with tag of (\""+tag+"\") should have the view we're looking for, but doesn't!");
            }
            view.requestFocus();
        }
        public void onTabUnselected(String tag) { }
    }

    // Our tab manager
    ActionBarTabManager mActionBarTabManager = null;

    // Our listener
    MyTabChangeListener mListener = new MyTabChangeListener();

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // instantiate our tab manager
        mActionBarTabManager = new ActionBarTabManager(this,R.id.actionbar_content,mListener);

        // remove the activity title to make space for tabs
        getActionBar().setDisplayShowTitleEnabled(false);

        // Add the tabs
        mActionBarTabManager.addTab("Tab 1", new MyFragment(), "Frag1");
        mActionBarTabManager.addTab("Tab 2", new MyFragment(), "Frag2");
    }
}