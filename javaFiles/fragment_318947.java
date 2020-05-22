@Override
public void setContentView(@LayoutRes int layoutResID) {
    super.setContentView(layoutResID);
    View view = findViewById(R.id.toolbarContainer);
    if (view != null) {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        setTitle(getTitle());
    }
}