public static <T extends Comparable<? super T>> List<List<List<T>>> level(List<List<T>> items, int level) {
    List<List<List<T>>> result = new ArrayList<>();
    for(int i = 0; i < level; i++) {
        if(i == 0) { // If level is 0, we can just add the items as singleton lists to the result
            for(List<T> item : items)
                result.add(Collections.singletonList(item));
            continue;
        }

        List<List<List<T>>> newResult = new ArrayList<>(); // Temporary items that will be added
        for(List<List<T>> item : result) {
            if(item.size() < i) // Make sure we are manipulating items that are on the previous level
                continue;

            List<List<List<T>>> combined = new ArrayList<>(); // The temporary values for this specific item
            for(int j = 0; j < items.size(); j++) {
                List<List<T>> current = new ArrayList<>(); // The current list with the value
                current.addAll(item); // Add the current items from result to the list
                current.add(items.get(j)); // Add the current item from items to the list

                if (i == level-1 && !check(current)) { // If this is the last level, and the current list shouldn't be added, skip adding
                    continue;
                }

                combined.add(current); // Add the current list to the combined values
            }

            newResult.addAll(combined); // Add all of the lists in combined to the new result
        }

        result = newResult; // Make result equal to the new result
    }

    return result;
}