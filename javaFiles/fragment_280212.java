public Object clone() {
    try {
        @SuppressWarnings("unchecked")
        ArrayList<E> v = (ArrayList<E>) super.clone();
        v.elementData = Arrays.copyOf(elementData, size);
        v.modCount = 0;
        return v;
    } catch (CloneNotSupportedException e) {
        // this shouldn't happen, since we are Cloneable
        throw new InternalError();
    }
}