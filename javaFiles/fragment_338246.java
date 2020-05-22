public class CustomArrayAdapter extends ArrayAdapter<ProdSample> {

private static class ViewHolder {
    private TextView itemView;
}

public CustomArrayAdapter(Context context, int textViewResourceId, ArrayList<ProdSample> items) {
    super(context, textViewResourceId, items);
}

public View getView(int position, View convertView, ViewGroup parent) 
{

    if (convertView == null) {
        convertView = LayoutInflater.from(this.getContext())
        .inflate(R.layout.your_list_item_layout, parent, false);

        viewHolder = new ViewHolder();
        viewHolder.itemView = (TextView) convertView.findViewById(R.id.your_textview_id_in_your_list_item_layout);

        convertView.setTag(viewHolder);
    } else {
        viewHolder = (ViewHolder) convertView.getTag();
    }

    ProdSample sample = getItem(position);
    if (item!= null) {

        viewHolder.itemView.setText(sample.toString());
    }

    return convertView;
  }
}