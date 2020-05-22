for (int i = 0; i < items.size(); i++) {
    Item childItem = items.get(i);
    if (childItem.getItemId() == item.getItemId()) {
          hideItemAndDescendants(childItem);
    }
}