public int hashCode() {
    int hashCode = 1;
    Iterator<E> i = iterator();
    while (i.hasNext()) {
        E obj = i.next();
        hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
    }
    return hashCode;
}