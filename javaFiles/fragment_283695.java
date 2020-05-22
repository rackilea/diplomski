for(Integer element : set) {
    int count = 0;
    i = list.iterator(); // resets the iterator to the first element. 
    while(i.hasNext()) {
        if(i.next() == element) {
            count++;
        }
    } // by the end of this loop the iterator has no next elements, need to reset.
    map.put(element, count);
}