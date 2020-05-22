final SparseBooleanArray checkedPositions = expList.getCheckedItemPositions();
final ExpandableListAdapter adapter = expList.getExpandableListAdapter();
List<Long> checkedIds = new ArrayList<Long>();
if (packedPositionType == ExpandableListView.PACKED_POSITION_TYPE_GROUP) {
    for (int i = checkedPositions.size() - 1; i >= 0; i--) {
        if (checkedPositions.valueAt(i)) {
            checkedIds.add(adapter.getGroupId(checkedPositions.keyAt(i)));
        }
    }
}