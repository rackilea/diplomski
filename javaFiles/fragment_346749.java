public class ExpandableListAdapter extends BaseExpandableListAdapter {
    ...
    public Set<Pair<Long, Long>> getCheckedItems() {
        return mCheckedItems;
    }
    ...
}