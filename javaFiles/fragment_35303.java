@Override
public void onBindViewHolder(final ViewHolder Viewholder, final int position) 

//add this line of code 

 Viewholder.setIsRecyclable(false);

//......your rest of the code will same