public void addPosition(Position addition) {

  //flag to track whether the new item exists in the list
  boolean itemExists = false;

  //go through the list looking for an item with the passed name to update
  for (Position existing : positions) {
    if (existing.getName().equals(addition.getName())) {
      existing.setQuantity(existing.getQuantity() + addition.getQuantity());
      itemExists = true;
    }
  }

  //if no matching item was found, add the new item
  if (!itemExists) {
    positions.add(addition);
  }
}