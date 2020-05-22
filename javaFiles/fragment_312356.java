@Override
public void onClick(View v) {
    notifyDataSetChanged();
    itemListener = sharedPreference.getListener();
    itemListener.recyclerViewListClicked(v, this.getLayoutPosition());
}