protected void onListItemClick(ListView l, View v, int position, long id) {
    final TextItem textItem = (TextItem) l.getAdapter().getItem(position);
    String textItemContents = textItem.getString(); //I don't know if this is actually correct. I don't know what the TextItem class is. But I think you get the idea.
    Intent intent = getIntentForString(textItemContents);
    startActivity(Intent);
}