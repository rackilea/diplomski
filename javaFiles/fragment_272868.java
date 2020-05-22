public View getView(int position, View view, ViewGroup parent) {
    DormViewHolder dormViewHolder;

    if(view == null) {
        view = layoutInflater.inflate(R.layout.listview_dorm_item, parent, false);

        dormViewHolder = new DormViewHolder();

        dormViewHolder.textViewDormName = (TextView) view.findViewById(R.id.list_item_dorm_item_name);
        dormViewHolder.textViewWasherAvail = (TextView) view.findViewById(R.id.list_item_washers_avail);
        dormViewHolder.textViewWasherOccupied = (TextView) view.findViewById(R.id.list_item_washer_occupied);
        dormViewHolder.textViewDryersAvail = (TextView) view.findViewById(R.id.list_item_dryers_avail);
        dormViewHolder.textViewDryersOccupied = (TextView) view.findViewById(R.id.list_item_dryers_occupied);

        // Set the View Tag with the ViewHolder to save View properties.
        view.setTag(dormViewHolder);
    }
    else
    {
        // Recycle the view (all View properties already set).
        dormViewHolder = (DormViewHolder) view.getTag();
    }

    dormViewHolder.textViewDormName.setText(list.get(position).dormName);
    dormViewHolder.textViewWasherAvail.setText(""+list.get(position).washersFree);
    dormViewHolder.textViewWasherOccupied.setText(""+list.get(position).washersInUse);
    dormViewHolder.textViewDryersAvail.setText(""+list.get(position).dryersFree);
    dormViewHolder.textViewDryersOccupied.setText(""+list.get(position).dryersInUse);
    return view;
}