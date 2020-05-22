public void add(ArrayList<String> list){
    this.list.clear();
    this.list.addAll(list);
    Log.d("List: ",this.list.toString());
    this.notifyDataSetChanged();
}
@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    rowView = convertView;

    if (rowView == null) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rowView = inflater.inflate(R.layout.message_list_layout, null);
        //configure view holder
        viewHolder = new ViewHolder();
        viewHolder.ItemText = (TextView) rowView.findViewById(R.id.list_item_text);
        rowView.setTag(viewHolder);
    }

    else {
        //fill data
        viewHolder = (ViewHolder) rowView.getTag();
    }

    viewHolder.ItemText.setText(list.get(position));

    return rowView;
}