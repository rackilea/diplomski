public synchronized void addImage(...) {
  Something newImage = .....
  List<Something> newPaintList = new ArrayList<>(paintList.size() + 1);
  newPaintList.addAll(paintList);
  newPaintList.add(newImage);
  paintList = newPaintList;
}