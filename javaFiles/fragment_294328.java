public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ResolveInfo> mItem;
    private PackageManager packageManager;

    public ListViewAdapter(Context context, ArrayList<ResolveInfo> items) {
        this.context = context;
        this.mItem = items;
        packageManager = context.getPackageManager();
        Collections.sort(mItem,new ResolveInfo.DisplayNameComparator(packageManager));
    }


    public int getCount(){
        return mItem.size();
    }

    @Override
    public ResolveInfo getItem(int position) {
        return mItem.get(position);
    }
    public long getItemId(int position){
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent){

        if (convertView  == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.testa, null);
        }

        ResolveInfo app =  mItem.get(position);

        TextView appName = (TextView) convertView.findViewById(R.id.tv_app_name);
        TextView appPackage = (TextView) convertView.findViewById(R.id.tv_app_package);
        ImageView icon = (ImageView) convertView.findViewById(R.id.app_icon);

        ActivityInfo activity = app.activityInfo;

        appPackage.setText(activity.applicationInfo.packageName);
        appName.setText(app.loadLabel(packageManager));
        icon.setImageDrawable(app.loadIcon(packageManager));



        return convertView;
    }
}