public static void main(String[] args) {
  ArrayList<ArrayList<String>> ArrayOfArrayList = new ArrayList<ArrayList<String>>();
  ArrayList<String> array = new ArrayList<String>();
  array.add("first.string1");
  array.add("first.string2");
  array.add("first.string3");
  ArrayOfArrayList.add(array);
  array = new ArrayList<String>();
  array.add("second.string1");
  array.add("second.string2");
  array.add("second.string3");
  ArrayOfArrayList.add(array);

  // assume array all have same number of elements;
  for (int i = 0; i < ArrayOfArrayList.get(0).size(); i++) {
    for (int j = 0; j < ArrayOfArrayList.size(); j++) {
       System.out.print(ArrayOfArrayList.get(j).get(i) + " ");
    }
    System.out.println();
  }
}