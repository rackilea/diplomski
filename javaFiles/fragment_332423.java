compareTo(Collection<T> other) {
    Iterator<T> i1 = this.iterator();
    Iterator<T> i2 = other.iterator();
    while(i1.hasNext() && i2.hasNext()) {
        int c = i1.next().compareTo(i2.next());
        if(c != 0) {
            return c;
        }
    }
    if(i1.hasNext()){
        return 1;
    } else if(i2.hasNext()) {
        return -1;
    } else {
        return 0;
    }
}