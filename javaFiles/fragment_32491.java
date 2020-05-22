public int findSmallest( int parent ) {

    int smallestChild = -1;

    int firstChild = parent * order + 1;
    int lastChild = parent * order + order;

    int currentSmallestChild = firstChild;

    for ( int i = firstChild + 1; i <= lastChild; i++ ) {
        if ( i > size || queue[i] == null ) {
            break;
        }
        if ( queue[currentSmallestChild].priority > queue[i].priority ) {
            currentSmallestChild = i;
            smallestChild = i;
        }
    }

    return smallestChild;

}