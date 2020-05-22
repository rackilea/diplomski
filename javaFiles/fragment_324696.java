@Override
public View getView(int position, View convertView, ViewGroup parent) {


   // TODO Auto-generated method stub
    if (convertView == null) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.custaddress, parent, false);
    }

final View rowView = convertView;

tripPickUp = (Button) rowView.findViewById(R.id.picked);
tripDelivered = (Button) rowView.findViewById(R.id.delivered);
tripIsDelivered = (TextView) rowView.findViewById(R.id.isdelivered);

if (tripsheet[position].getPicked() == false
        && tripsheet[position].isDelivered() == false) {
    tripPickUp.setVisibility(View.VISIBLE);
    tripDelivered.setVisibility(View.INVISIBLE);
    tripIsDelivered.setVisibility(View.INVISIBLE);
    rowView.setBackgroundResource(Color.WHITE);
}

else if (tripsheet[position].isDelivered() == false
        && tripsheet[position].getPicked() == true) {
    tripPickUp.setVisibility(View.INVISIBLE);
    tripDelivered.setVisibility(View.VISIBLE);
    tripIsDelivered.setVisibility(View.INVISIBLE);
    rowView.setBackgroundResource(Color.WHITE);

} else {
    tripDelivered.setVisibility(View.INVISIBLE);
    tripIsDelivered.setVisibility(View.VISIBLE);
    tripPickUp.setVisibility(View.INVISIBLE);
    rowView.setBackgroundResource(R.color.gray);
}

return rowView;
}