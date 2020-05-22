List<List<String>> stringList = new ArrayList<List<String>>(); // Input
List<List<Integer>> intList = new ArrayList<List<Integer>>(); // Output
for (List<String> item : stringList) {
    List<Integer> temp = new ArrayList<Integer>();
    for (String subItem : item) {
        temp.add(Integer.parseInt(subItem));
    }
    intList.add(temp);
}