@Override
public int getItemViewType(int position) {
  if (getItem(position).isSection()) {
    return(0);
  }

  return(1);
}