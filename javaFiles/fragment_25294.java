@Override
public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
final CardItem item = mCardItems.get(i);
personViewHolder.FavBut.setOnClickListener(new OnClickListener(){
    public void onClick(View v){
        mItemClickListener.onItemClick(item);
    }

});