@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View row = convertView;
    viewHolder holder = null;
    if (row==null){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.contact_list_style,parent,false);
        holder = new viewHolder(row);
        row.setTag(holder);
        // ^^^ set the tag
    }else{
        Toast.makeText(context, "GRRRRRRRRRRR", Toast.LENGTH_SHORT).show();
        holder=(viewHolder)row.getTag();
        // do this , initialize your holder otherwise holder stays null
    }
    RowData temp = list.get(position);
    holder.user_name.setText(temp.user_name);
    holder.message_stats.setImageResource(temp.message_status);
    holder.user_img.setImageResource(temp.user_img);
    holder.user_message.setText(temp.user_msg);
    return row;
}