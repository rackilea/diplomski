public ClickableListAdapter(Context context, int viewid, List objects) {  

        // Cache the LayoutInflate to avoid asking for a new one each time.  
        mInflater = LayoutInflater.from(context);  
        mDataObjects = objects;  
        mViewId = viewid;