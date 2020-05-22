for (String fruit : theFruits) {
  String firstLetter = fruit.substring(0, 1);
  Integer count = myMap.get(firstLetter);
  if (count == null) {
    myMap.put(firstLetter, 1);
  }
  else {
    myMap.put(firstLetter, ++count);
  }
}