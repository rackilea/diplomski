@Override
public int getChildrenCount(int groupPosition) {
    List childList = listDataChild.get(listDataItem.get(groupPosition));
    if (childList != null && ! childList.isEmpty()) {
        return childList.size();
    }
    return 1;
}