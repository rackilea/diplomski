public class AppAdapter extends BaseAdapter {

    private AppSelector appSelector;
    private List<AppList> listStorage;

    public AppAdapter(AppSelector appSelector, List<AppList> customizedListView) {
        this.appSelector = appSelector;
        listStorage = customizedListView;
    }

    ....

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.installed_app_list, parent, false);

            listViewHolder.textInListView = (TextView)convertView.findViewById(R.id.list_app_name);
            listViewHolder.imageInListView = (ImageView)convertView.findViewById(R.id.app_icon);
            listViewHolder.checkBox = (CheckBox)convertView.findViewById(R.id.checkBox);
            convertView.setTag(listViewHolder);
            listViewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        appSelector.selectApp(listStorage.get(position).getName());
                    } else {
                        appSelector.removeApp(listStorage.get(position).getName());
                    }
                }
            });
        } else {
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.textInListView.setText(listStorage.get(position).getName());
        listViewHolder.imageInListView.setImageDrawable(listStorage.get(position).getIcon());
        listViewHolder.checkBox.setChecked(appSelector.isSelected(listStorage.get(position).getName()));

        return convertView;
    }

    ....
}