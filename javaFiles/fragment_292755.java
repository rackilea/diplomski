public Element getNthMax(List<List<Integer>> sums, int n) {
    List<Element> flatList = new ArrayList<Element>();

    for (int i = 0; i < sums.size(); i++) {
        List<Integer> innerList = sums.get(i);
        for (int j = 0; j < innerList.size(); j++) {
            Element e = new Element(innerList.get(j), j, i);
            flatList.add(e);
        }
    }

    Collections.sort(flatList);
    return flatList.get(n);
}