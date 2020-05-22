public int hashCode() {
    int h = 0;
    Iterator<E> i = iterator();
    while (i.hasNext()) {
        E obj = i.next();
        if (obj != null)
            h += obj.hashCode(); // when obj == this, as in your case, this
                                 // call leads to infinite recursion
    }
    return h;
}