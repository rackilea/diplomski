public View getGroupView(int groupPosition, boolean isExpanded,
        View convertView, ViewGroup parent) {

    GroupViewholder holder;
    if (convertView == null) {  
        holder = new GroupViewHolder();  // try putting it here
        convertView = minflater.inflate(R.layout.grouprow, null);  
        holder.mIcon = (ImageView) convertView.findViewById(R.id.img);
    }