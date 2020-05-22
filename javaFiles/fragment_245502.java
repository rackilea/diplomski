List items = new ArrayList();
//some fictitious objectList where we're populating data
for(Object obj : objectList) {
// THE KEY IS TO ADD THE ITEM AT POITIN 0

    items.add(0, obj);
    listAdapter.notifyDataSetChanged();
}
//THIS WILL REFRESH THE LISTVIEW
listView.post(new Runnable() {
    @Override
    public void run() {
        listView.smoothScrollToPosition(0);
    }
}