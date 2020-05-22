public class SettingsActivity extends PreferenceActivity {
private static final String STATE_CUR_HEADER_POS = "Current Position";
private static final String STATE_HEADERS_LIST   = "Headers List";

private int mCurPos = AdapterView.INVALID_POSITION;  //Manually track selected header position for dual pane mode
private ArrayList<Header> mHeaders;  //Manually track headers so we can select one. Required to support ICS.  Otherwise JB exposes a getter instead.

@Override
public void onBuildHeaders(List<Header> target) {
    loadHeadersFromResource(R.xml.preference, target);
    mHeaders = (ArrayList<Header>) target;  //Grab a ref of the headers list
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //This is the only code required for ensuring a dual pane mode shows after rotation of a single paned preference screen
    if (onIsMultiPane() && onIsHidingHeaders()) {
        finish();
    }
}

@Override
public boolean onIsMultiPane() {
    //Override this if you want dual pane to show up on smaller screens
    return getResources().getBoolean(R.bool.pref_prefer_dual_pane);
}

@Override
protected void onListItemClick(ListView l, View v, int position, long id) {
    super.onListItemClick(l, v, position, id);

    //Intercept a header click event to record its position.
    mCurPos = position;
}

@Override
protected void onRestoreInstanceState(Bundle state) {
    super.onRestoreInstanceState(state);

    //Retrieve our saved header list and last clicked position and ensure we switch to the proper header.
    mHeaders = state.getParcelableArrayList(STATE_HEADERS_LIST);
    mCurPos = state.getInt(STATE_CUR_HEADER_POS);
    if (mHeaders != null) {
        if (mCurPos != AdapterView.INVALID_POSITION) {
            switchToHeader(mHeaders.get(mCurPos));
        } else {
            switchToHeader(onGetInitialHeader());
        }
    }
}

@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);

    //Persist our list and last clicked position
    if (mHeaders != null && mHeaders.size() > 0) {
        outState.putInt(STATE_CUR_HEADER_POS, mCurPos);
        outState.putParcelableArrayList(STATE_HEADERS_LIST, mHeaders);
    }
}
}