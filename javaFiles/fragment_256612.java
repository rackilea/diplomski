private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

    public void addTab(ImageButton btn, Class<?> clss, Bundle args) {
    TabInfo info = null;
    if (mContext.getSupportFragmentManager().getFragments() != null && mContext.getSupportFragmentManager().getFragments().size() > 0) {
        for (Fragment fragment : mContext.getSupportFragmentManager().getFragments()) {
            if((int)btn.getTag() == 0 && fragment instanceof Fragment1_){
                info = new TabInfo(fragment.getClass(), fragment, btn, args);
                continue;
            }
            if((int)btn.getTag() == 1 && fragment instanceof Fragment2_){
                info = new TabInfo(fragment.getClass(), fragment, btn, args);
                continue;
            }
            if((int)btn.getTag() == 2 && fragment instanceof Fragment3_)
            {
                info = new TabInfo(fragment.getClass(), fragment, btn, args);
                continue;
            }
        }
    }

    if(info == null) {
        info = new TabInfo(clss, null, btn, args);
    }

    btn.setOnClickListener(this);
    mTabs.add(info);
    notifyDataSetChanged();
}