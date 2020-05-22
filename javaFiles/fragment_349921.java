private void doSomething() {
  String[][] array = {{"one", "1"},{"two","2"}, {"three","3"}};
  Point index = find2DIndex(array, "two");

  // change one value at index
  if (index != null)
     array[index.x][index.y] = "TWO";

  // change everything in the whole row
  if (index != null) {
     String[] row = array[index.x];
     // change the values in that row
  }

}