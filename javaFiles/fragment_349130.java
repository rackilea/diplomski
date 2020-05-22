class SortedListView extends AbstractList<String> implements RandomAccess {
  // stringArray, idxes should be fields, initialized in a constructor
  public int size() {
    return stringArray.length;
  }
  public String get(int index) {
    return stringArray[idxes[index]];
  }
};