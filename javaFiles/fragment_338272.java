private static void solution_withRecursion(List<int[]> resultList, int mapIndex) {
    if (mapIndex == allLists.size()) {
        printListValues(resultList);
        return;
    }
    for (int i = 0; i < allLists.get(mapIndex).size(); i++) {
        int[] tmpArray = allLists.get(mapIndex).get(i);
        try {
            resultList.set(mapIndex, tmpArray);
        } catch (IndexOutOfBoundsException e) {
            resultList.add(tmpArray);
        }
        solution_withRecursion(resultList, mapIndex + 1);
    }
}


private static void printListValues(List<int[]> list) {
    for (int[] arr : list) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    System.out.println();
}