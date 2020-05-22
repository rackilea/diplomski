Iterator<E> it = collection.iterator;
E max = null;
while(it.hasNext()) {
    if(max == null) {
        max = it.next();
    } else {
        e = it.next();
        if(e.compareTo(max) > 0) {
            max = e;
        }
    }
}