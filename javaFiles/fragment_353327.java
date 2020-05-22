// binds the data to the TextView in each row
@Override
public void onBindViewHolder(ViewHolder holder, int position) {

    holder.keyID.setText(mData.get(position));
    holder.lockID.setText(mData.get(position));
    holder.eventTime.setText(mData.get(position));
    holder.eventType.setText(mData.get(position));
}