public ArrayList<Integer> find(String name, ArrayList<String> names) {
  ArrayList<Integer> duplicateIndices = new ArrayList<Integer>();
  for (int i = 0; i < names.size(); i++) {
    if (names.get(i).equals(name)) {
      duplicateIndices.add(new Integer(i));
    }
  }
  return duplicatIndices;
}