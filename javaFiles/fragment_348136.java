@Override
public boolean onTouch(View v, MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_DOWN) {
        ArrayAdapter adapter = (ArrayAdapter) getAdapter();

        if (null != adapter) {

            if (_items.size() == 0) {
                for (int i = 0; i < adapter.getCount(); i++) {
                    _items.add(adapter.getItem(i));
                }
            }
            SearchableListDialog searchableListDialog = SearchableListDialog.newInstance
                    (_items);
            searchableListDialog.setOnSearchableItemClickListener(this);
            searchableListDialog.show(((Activity) _context).getFragmentManager(), "TAG");
        }
    }
    return true;
}