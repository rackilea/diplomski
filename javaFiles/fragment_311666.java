@Override
public View getChildView(int groupPosition, int childPosition, boolean 
    isLastChild, View convertView, ViewGroup parent) {
    if(convertView == null)
    {
        convertView = LayoutInflater.from(context).inflate(R.layout.list_row_child,null);
        childViewHolder = new ChildViewHolder(convertView, groupPosition, childPosition);        
        convertView.setTag(childViewHolder);
    }
    else{
        childViewHolder = (ChildViewHolder) convertView.getTag();
    }
  childViewHolder.childTitle.setText(groupItem.get(groupPosition)
 .getChildTitles().get(childPosition));

      return convertView;

}