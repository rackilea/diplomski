Collections.sort(selection1, new Comparator<Integer>() {
  @Override public int compare(Integer key1, Integer key2) {
    return Float.compare(
         population1.get(key1).valeur, population1.get(key2).valeur);
  }
});