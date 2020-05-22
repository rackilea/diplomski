onClickNewDirectory() {
  position = position + 1
  Object object = new Object(position, directory, ...);
  arraylist.add(object)
}

onbackToPreviousDirectory() {
  //delete last element of position
  arraylist.remove(arraylist.size() - 1);
  position = position - 1
}