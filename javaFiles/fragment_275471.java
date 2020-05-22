@Override
public void onBindViewHolder (MyHolder holder, int position) {

    ItemObject itemObject = list.get(position);
    holder.itemObject = itemObject;

    // the rest of your bind code....

}