if (convertView == null) {
    // You can move this line into your constructor, the inflater service won't change.
    mInflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
    if(getItemViewType(position) == 0)
        convertView = mInflater.inflate(R.layout.listview_item_product_complete, parent, false);
    else
        convertView = mInflater.inflate(R.layout.listview_item_product_inprocess, parent, false);
    // etc, etc...