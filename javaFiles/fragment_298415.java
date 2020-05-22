Integer[] tree = new Integer[array.length]
//the element to add is array[i]
for (int i = 0; i < array.length; ++i) {
    //every iteration starts from the root node
    int pos = 0;
    //while the cell is not empty
    while (tree[pos] != null) {
        //if the cell is smaller than the element
        if (tree[pos] < array[i]) {
            //go to 2n+1
            pos = 2 * pos + 1;
        } else {
            //go to 2n+2
            pos = 2 * pos + 2;
        }
    }
    //add at the empty position.
    tree[pos] = array[i];
}