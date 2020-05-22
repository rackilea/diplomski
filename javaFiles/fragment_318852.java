StringBuffer allItems = new StringBuffer();

Adapter adapter = listView.getAdapter();
for (int i=0; i<adapter.getCount(); i++) {
    Object item = adapter.getItem(i);
    allItems.append(item.toString());
    allItems.append(", ");
}

textView.setText(allItems.toString());