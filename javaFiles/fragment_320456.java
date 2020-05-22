public int next() throws NoSuchElementException {
    int result = -1;
    //Are we already iterating one of the second dimensions?
    if(current!=null && current.hasNext()) {
        //get the next element from the second dimension.
        result =  current.next();
    } else if(values != null && values.hasNext()) {
        //get the next second dimension
        current = values.next();
        if (current.hasNext()) {
            //get the next element from the second dimension
            result =  current.next();
        } 
    } else {
        //we have iterated all the second dimensions
        throw new NoSuchElementException("Reached end");
    }

    return result;

}