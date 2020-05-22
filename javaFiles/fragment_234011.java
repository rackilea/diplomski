public class DrawerListAdapter extends BaseAdapter{

private Context context;
private String[] mTitle;
private int[] mIcon;
private LayoutInflater inflater;

public DrawerListAdapter(Context pContext, String[] pTitle, int[] pIcon) {
    super();
    context = pContext;
    mTitle = pTitle;
    mIcon = pIcon;
}

public View getView(int position, View convertView, ViewGroup parent) {
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rootView = inflater.inflate(R.layout.navigation_drawer_list_item, parent, false);

    TextView txtTitle = (TextView) rootView.findViewById(R.id.drawer_text);
    ImageView imgIcon = (ImageView) rootView.findViewById(R.id.drawer_icon);

    if(((ListView)parent).isItemChecked(position)) {
            txtTitle.setTextColor(parent.getResources().getColor(R.color.DarkerRed));
    }
    txtTitle.setText(mTitle[position]);
    imgIcon.setImageResource(mIcon[position]);

    return rootView;
}

@Override
public int getCount() {
    return mTitle.length;
}

@Override
public Object getItem(int position) {
    return mTitle[position];
}

@Override
public long getItemId(int position) {
    return position;
}