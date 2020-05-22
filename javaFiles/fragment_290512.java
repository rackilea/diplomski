return getWindow().findViewById(id);

//in the window, (PhoneWindow)
@Nullable
    public <T extends View> T findViewById(@IdRes int id) {
        return getDecorView().findViewById(id);
    }
// the DecorView is the basic view, it set when you call setContentView
public void setContentView(@LayoutRes int layoutResID) {
        getWindow().setContentView(layoutResID);
        initWindowDecorActionBar();
    }
//PhoneWindow setContentView
@Override
    public void setContentView(View view) {
        setContentView(view, new ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT));
    }
@Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
  // decor, when theme attributes and the like are crystalized. Do not 
  // check the feature
        // before this happens.
        if (mContentParent == null) {
            installDecor(); // this method init DecorView
       } else if (!hasFeature(FEATURE_CONTENT_TRANSITIONS)) {
            mContentParent.removeAllViews();
        }
...
}