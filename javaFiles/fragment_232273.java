public static void setListViewHeight(ExpandableListView listView, int group) {
    ExpandableListAdapter listAdapter = (ExpandableListAdapter) listView.getExpandableListAdapter();
    int totalHeight = 0;
    int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
            View.MeasureSpec.EXACTLY);
    for (int i = 0; i < listAdapter.getGroupCount(); i++) {
        View groupItem = listAdapter.getGroupView(i, false, null, listView);
        groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

        totalHeight += groupItem.getMeasuredHeight();

        if (((listView.isGroupExpanded(i)) && (i != group)) || ((!listView.isGroupExpanded(i)) && (i == group))) {
            for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                View listItem = listAdapter.getChildView(i, j, false, null,
                        listView);
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                totalHeight += listItem.getMeasuredHeight()+1;

            }
        }
    }

    ViewGroup.LayoutParams params = listView.getLayoutParams();
    int height = totalHeight
            + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
    if (height < 10)
        height = 200;
    params.height = height;
    listView.setLayoutParams(params);
    listView.requestLayout();

}