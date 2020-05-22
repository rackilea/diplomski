Iterator<T> itr = collection.iterator();
while(itr.hasNext()) {
    T obj = itr.next();
    if(removeObj) {
        itr.remove();
    }
}