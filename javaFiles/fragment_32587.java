ListAdapter listadp = listview.getAdapter();
       if (listadp != null) {
           int totalHeight = 0;
           for (int i = 0; i < listadp.getCount(); i++) {
               View listItem = listadp.getView(i, null, listview);
               listItem.measure(0, 0);
               totalHeight += listItem.getMeasuredHeight();
           }
           ViewGroup.LayoutParams params = listview.getLayoutParams();
           params.height = totalHeight + (listview.getDividerHeight() * (listadp.getCount() - 1));
           listview.setLayoutParams(params);
           listview.requestLayout();