private class AppsAdapter extends BaseAdapter {

    private final Activity mContext;
    private final App[] apps;

    public AppsAdapter(Activity context, App[] appList) {
      mContext = context;
      apps = appList;
    }

    public int getCount() {
      return apps.length;
    }

    public App getItem(int position) {
      return apps[position];
    }

    public long getItemId(int position) {
      return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
      View gridItem;

      gridItem = new View(mContext);
      /* app_cell is the layout for the individual items */
      gridItem = inflater.inflate(R.layout.app_cell, null);
      ImageView appIcon = (ImageView) gridItem.findViewById(R.id.app_cell_icon);
      TextView appTitle = (TextView) gridItem.findViewById(R.id.app_cell_title);

      if (appIcon != null && appTitle != null) {
        mContext.loadImage(apps[position].getIcon(), appIcon);
        appTitle.setText(apps[position].getTitle());
      }

      return gridItem;
    }

    @Override
    public int getViewTypeCount() {
      return 1;
    }
  }