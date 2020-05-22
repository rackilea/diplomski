public void insert(int x){
    // loop through all elements
    for (int i = 0; i < size(); i++) {
        // if the element you are looking at is smaller than x, 
        // go to the next element
        if (get(i) < x) continue;
        // if the element equals x, return, because we don't add duplicates
        if (get(i) == x) return;
        // otherwise, we have found the location to add x
        add(i, x);
        return;
    }
    // we looked through all of the elements, and they were all
    // smaller than x, so we add ax to the end of the list
    add(x);
}