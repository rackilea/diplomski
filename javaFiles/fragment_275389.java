@Override
public void onBindViewHolder(MyViewHolder holder, int position) {
    currentListItem = List.get(position);
    if(position == 0) //this will let you know the first child item
    {
       holder.textview.setBackgroundColor(Color.RED);
    }   
}