public class ConfigureMyOrderAdapter extends BaseExpandableListAdapter {

private Context context;
private ArrayList<ExpandableConfigureGroup> groups;
private ExpandableListView mExpandableListView;
private int[] groupStatus;

public ConfigureMyOrderAdapter(Context context,
        ExpandableListView mExpandableListView,
        ArrayList<ExpandableConfigureGroup> groups) {
    this.context = context;
    this.groups = groups;
    this.mExpandableListView = mExpandableListView;
    groupStatus = new int[groups.size()];

    setListEvent();
}

private void setListEvent() {

    mExpandableListView
            .setOnGroupExpandListener(new OnGroupExpandListener() {
                @Override
                public void onGroupExpand(int arg0) {
                    // TODO Auto-generated method stub
                    groupStatus[arg0] = 1;
                }
            });

    mExpandableListView
            .setOnGroupCollapseListener(new OnGroupCollapseListener() {
                @Override
                public void onGroupCollapse(int arg0) {
                    // TODO Auto-generated method stub
                    groupStatus[arg0] = 0;
                }
            });
}

public void addItem(ExpandableConfigureChild item,
        ExpandableConfigureGroup group) {
    if (!groups.contains(group)) {
        groups.add(group);
    }
    int index = groups.indexOf(group);
    ArrayList<ExpandableConfigureChild> ch = groups.get(index).getItems();
    ch.add(item);
    groups.get(index).setItems(ch);
}

public Object getChild(int groupPosition, int childPosition) {
    ArrayList<ExpandableConfigureChild> chList = groups.get(groupPosition)
            .getItems();
    return chList.get(childPosition);

}

public long getChildId(int groupPosition, int childPosition) {
    return childPosition;
}

@Override
public View getChildView(int groupPosition, int childPosition,
        boolean arg2, View view, ViewGroup arg4) {
    ExpandableConfigureChild child = (ExpandableConfigureChild) getChild(
            groupPosition, childPosition);

    if (view == null) {
        @SuppressWarnings("static-access")
        LayoutInflater infalInflater = (LayoutInflater) context
                .getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = infalInflater.inflate(
                R.layout.configure_list_raw_group_item, null);
    }
     TextView tv_price = (TextView) view.findViewById(R.id.item_price);
     tv_price.setText(child.getTag().toString());
     tv_price.setTag(child.getTag());

    return view;

}

@Override
public int getChildrenCount(int groupPosition) {
    ArrayList<ExpandableConfigureChild> chList = groups.get(groupPosition)
            .getItems();
    return chList.size();
}

@Override
public Object getGroup(int groupPosition) {
    return groups.get(groupPosition);
}

@Override
public int getGroupCount() {
    return groups.size();
}

@Override
public long getGroupId(int groupPosition) {
    return groupPosition;
}

@SuppressWarnings("static-access")
@Override
public View getGroupView(int groupPosition, boolean arg1, View view,
        ViewGroup arg3) {
    ExpandableConfigureGroup group = (ExpandableConfigureGroup) getGroup(groupPosition);
    if (view == null) {
        LayoutInflater inf = (LayoutInflater) context
                .getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inf.inflate(R.layout.configure_list_raw_group, null);
    }
    TextView tv = (TextView) view.findViewById(R.id.txtRestaurantMenuName);
    tv.setText(group.getName());

    ImageView img = (ImageView) view.findViewById(R.id.img_rightarrow);
    if (groupStatus[groupPosition] == 0) {
        img.setImageResource(R.drawable.navigation_next);
    } else {
        img.setImageResource(R.drawable.navigation_expandable);
    }
    return view;
}

@Override
public boolean hasStableIds() {
    return true;
}

@Override
public boolean isChildSelectable(int arg0, int arg1) {
    return true;
}

}