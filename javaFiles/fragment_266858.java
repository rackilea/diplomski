if(view == null)
{
    view = mInflator.inflate(R.layout.device_list, null);
    viewHolder = new ViewHolder();

    viewHolder.deviceRssi = (TextView) view.findViewById(R.id.device_rssi);

    view.setTag(viewHolder); //THE CODE

}
else 
{
     viewHolder = (ViewHolder) view.getTag();
     viewHolder.deviceRssi.setText("RSSI:" + String.valueOf(mrssi));

}

                    return view;