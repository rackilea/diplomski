elvItemList.setOnItemLongClickListener(new OnItemLongClickListener() {
@Override
public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
if (ExpandableListView.getPackedPositionType(id) == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
// Your code with group long click
return true;
}
return false;
}
});