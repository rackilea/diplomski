public Door(Color... colors) {
  addAll(colors);
}

public void addAll(Color... colors) {
  for (Color color : colors) {
    myList.add(color);
  }
}