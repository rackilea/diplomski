protected List<RowItem> doInBackground(RowItem... rowItems) {
  rowItems = new ArrayList<RowItem>();
  Bitmap map = null;
  for (String url : urls) {
    map = downloadImage(url);
    rowItems.add(new RowItem(map));
  }
  return rowItems;
}