public class ExpandableListAdapter extends BaseExpandableListAdapter {
    ...
    private final Set<Pair<Long, Long>> mCheckedItems = new HashSet<Pair<Long, Long>>();
    ...
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ...

        final CheckBox cb = (CheckBox) convertView.findViewById(R.id.your_checkbox_id);
        // add tag to remember groupId/childId
        final Pair<Long, Long> tag = new Pair<Long, Long>(
            getGroupId(groupPosition),
            getChildId(groupPosition, childPosition));
        cb.setTag(tag);
        // set checked if groupId/childId in checked items
        cb.setChecked(mCheckedItems.contains(tag));
        // set OnClickListener to handle checked switches
        cb.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                final CheckBox cb = (CheckBox) v;
                final Pair<Long, Long> tag = (Pair<Long, Long>) v.getTag();
                if (cb.isChecked()) {
                    mCheckedItems.add(tag);
                } else {
                    mCheckedItems.remove(tag);
                }
            }
        });

        ...

    }
    ...
}