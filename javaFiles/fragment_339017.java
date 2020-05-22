protected <T extends ViewDataBinding> T inflateActivityViewInFrame(
        int layoutId, int titleStringId) {
  LayoutInflater inflater = (LayoutInflater)
      getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  T binding = DataBindingUtil.inflate(inflater, layoutId, mFrameLayout, true);
  setupActionBarAndDrawerToggle(titleStringId);
}