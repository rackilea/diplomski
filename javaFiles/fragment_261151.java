public class CustomAdapter extends ArrayAdapter<FeedsDTO>{
private LayoutInflater inflater;
private int layoutID;
public CustomAdapter(Context cntx, int resource, List<FeedsDTO> objects) {
    super(cntx, resource, objects);
    this.inflater =(LayoutInflater) cntx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.layoutID = resource;
}
@Override
public View getView(int position, View convertView, ViewGroup parent) {
    try {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(layoutID, null);
            holder = new ViewHolder();
            holder.NameTV = (TextView) convertView.findViewById(R.id.textview);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        FeedsDTO feedsDTO = getItem(position);
        holder.NameTV.setText(feedsDTO.getName());

        feedsDTO = null;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return convertView;
}
private class ViewHolder{
    TextView NameTV;
}