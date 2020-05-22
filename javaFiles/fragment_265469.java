this.contents = new ArrayList<ArrayList<GameObject>>(rows); // this creates an empty 
                                                            // ArrayList
for (int i = 0; i < rows; i++) { // this populates the ArrayList with rows empty ArrayLists
    this.contents.add(new ArrayList<GameObject>(cols));
    // and possibly add another loop to populate the inner array lists
}