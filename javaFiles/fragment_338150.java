protected void removeRange(int fromIndex, int toIndex) {
    ListIterator<E> it = listIterator(fromIndex);
    for (int i = 0, n = toIndex - fromIndex; i < n; i++) {
        E item = it.next();
        //it.remove();
        for (int j = ; j < n; j++) {
            if (list.get(j).equals(e)) {
                list.remove(e);
                break;
            }
        }
    }
}