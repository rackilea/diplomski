List<Integer> originalList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 1, 1, 2, 3, 1, 2, 3, 4, 5, 6));
    List<List<Integer>> finalList = new ArrayList<>();
    List<Integer> currentList = new ArrayList<>();
    for (Integer current : originalList) {
        if (current == 1) {
            if (!currentList.isEmpty()) {
                finalList.add(currentList);
            }
            currentList = new ArrayList<>();
        }
        currentList.add(current);
    }
    if (!currentList.isEmpty()) {
         finalList.add(currentList);
    }