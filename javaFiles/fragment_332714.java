private void showListPopupWindow(View anchor) {
    final ListPopupWindow popupWindow = new ListPopupWindow(this);

    List<Item> itemList = new ArrayList<>();
    itemList.add(new Item("A", R.mipmap.ic_launcher));
    itemList.add(new Item("B", R.mipmap.ic_launcher));
    itemList.add(new Item("C", R.mipmap.ic_launcher));

    ListAdapter adapter = new ListPopupWindowAdapter(this, itemList);
    popupWindow.setAnchorView(anchor);
    popupWindow.setAdapter(adapter);
    popupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            popupWindow.dismiss();
        }
    });
    popupWindow.show();
}