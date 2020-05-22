public Set<String> getDinerItems() {
  Set<String> itemNames = new HashSet<String>();
  for (Diner d : diners) {
    for (Item i : d.getItemList()) {
      itemNames.add(i.getName());
    }
  }
  return itemNames;
}