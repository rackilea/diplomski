ArrayList<ListItem> items = new ArrayList<ListItem>();
  for(int i = 0; i < 100; i++) {
  int num = i + 1;
  ListItem l = new ListItem("Item " + num, "sub item " + num);
  items.add(l);
}