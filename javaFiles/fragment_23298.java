@Override
public void onBindViewHolder(final RecyclerAdapter.ViewHolder holder, int position) {
    DataItem dataItem = dataList.get(holder.getAdapterPosistion());
    try {
        int resID = activityContext.getResources().getIdentifier(dataItem.getIconName() , "drawable"/**resource folder name*/, activityContext.getPackageName());
        holder.imageView.setBackgroundResource(resID);
    } catch (Exception e) {
        throw new RuntimeException("Error getting Resource ID.", e)
    }
}