public void updateDataSet(List<Item> items)
{
    //mItemList is the adapters member list
    if (null != mItemList)
    {
        mItemList.clear();
        mItemList.addAll(items);
    }
    else
        mItemList = items;

    notifyDataSetChanged();
}