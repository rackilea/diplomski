public List<List<Integer>> resizeListOfNestedList(int newSize, List<List<Integer>> data) {

    ArrayList<Integer> allElements = new ArrayList<>();

    for (List<Integer> integers : data) {
        allElements.addAll(integers);
    }

    int elementsPerItem = allElements.size() / newSize;
    int extraElements  = allElements.size() % newSize;
    int indexToStartAddExtraElement = newSize - extraElements;

    ArrayList<List<Integer>> result = new ArrayList<>(newSize);
    Iterator<Integer> iterator = allElements.iterator();

    for (int i = 0; i < newSize; i++){

        int currentItemElementsCount = elementsPerItem;

        if (i >= indexToStartAddExtraElement)
            currentItemElementsCount++;

        ArrayList<Integer> current = new ArrayList<>(currentItemElementsCount);

        for (int j = 0; j < currentItemElementsCount; j++){
            current.add(iterator.next());
        }

        result.add(current);
    }

    return result;
}