@Override
public Object getItem(int position) {
    //Return full object, coz we need to access other 
    //member variables too
    return mData.get(position);
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder holder;

    if (convertView == null) {
        convertView = mInflater.inflate(R.layout.list_item_dualline, parent, false);
        holder = new ViewHolder();

        holder.title = (TextView) convertView.findViewById(R.id.item_station);
        holder.description = (TextView) convertView.findViewById(R.id.item_zone);

        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    Victoria victoria = (Victoria)getItem(position);
    holder.title.setText(victoria.getStation());
    holder.description.setText(victoria.getZone());
    if (victoria.isSelected()) {
        setItemSelected(convertView);
    } else {
        setItemNormal(convertView);
    }

    return convertView;
}

 public void setItemSelected(View view) {
    View rowView = view;
    view.setBackgroundColor(Color.parseColor("#868F98"));

    TextView tv0 = (TextView) rowView.findViewById(R.id.item_station);
    tv0.setTextColor(Color.WHITE);

    TextView tv1 = (TextView) rowView.findViewById(R.id.item_zone);
    tv1.setTextColor(Color.WHITE);
 }

public void setItemNormal(View v) {

    v.setBackgroundColor(Color.TRANSPARENT);

    TextView tv0 = ((TextView) v.findViewById(R.id.item_station));
    tv0.setTextColor(Color.WHITE);

    TextView tv1 = ((TextView) v.findViewById(R.id.item_zone));
    tv1.setTextColor(Color.parseColor("#B5B5B5"));

 }