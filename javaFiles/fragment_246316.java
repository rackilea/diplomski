@Override
public void onBindViewHolder(DataObjectHolder holder, int position) {
    holder.label.setText(mDataset.get(position).getmText1());
    Picasso.with(context).load(mDataset.get(position).getImageUrl()).into(holder.imgViewIcon);
    holder.description.setText(mDataset.get(position).getmText2());
}