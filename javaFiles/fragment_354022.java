@Override
public View getGroupView(final int groupPosition, final boolean isExpanded, View convertView, final ViewGroup parent) {
    if(convertView == null) {
        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item, parent, false);
    }

    ImageButton button1 = (ImageButton) convertView.findViewById(R.id.button_1);

    button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isExpanded) ((ExpandableListView) parent).collapseGroup(groupPosition);
            else ((ExpandableListView) parent).expandGroup(groupPosition);
        }
    });

    return convertView;
}