for (int i = 0; i < aList.size(); i++) {
    //the flag
    boolean duplicate = false;        

    for (int j = i + 1; j < aList.size(); j++) {
        if (Objects.equals(aList.get(i), aList.get(j))) {
            aList.set(j, "");   //remove all duplicates with an index higher than i
            duplicate = true;   //remember that element at index i is a duplicate
        }
    }

    //remove last duplicate element
    if(duplicate)
        aList.set(i, "");
}