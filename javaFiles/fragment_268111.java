getListView().setOnItemClickListener(new OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
            long arg3) {
        itm = getListView().getItemAtPosition(pos).toString();
        selectItem(pos);
     }
 });