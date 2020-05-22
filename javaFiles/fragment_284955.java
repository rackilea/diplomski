if (mapOfCats.contains(newCat.id)) {
  Cat current = mapOfCats.get(newCat.id);
  if (!current.equals(newCat)) {
    mapOfCats.put(newCat.id, newCat);
    // notify EventBusses and such
  }
}