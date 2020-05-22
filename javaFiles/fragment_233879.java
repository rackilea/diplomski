ViewHolder viewHolder = new ViewHolder();
if (convertView == null) {
    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    .
    .
    .
} 
else {
    viewHolder = convertView.getTag();
}