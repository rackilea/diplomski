for (int i = ids.length - 1; i > 0; i--) { // Downward for efficiency
    final String id = ids[i];
    // Big optimization: we don't have to search the full list as the part
    // before i is already sorted and object for id can only be on the remaining
    for (int j = i; j >= 0; j--) // NOTE: loop starting at i
        if (id.equals(myList.get(j).getId()) {
            Collections.swap(myList, j, i);
            break;
        }
}