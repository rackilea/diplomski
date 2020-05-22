public boolean contains(Object o) {
    return indexOf(o) >= 0;
}

public int indexOf(Object o) {
    return indexOfRange(o, 0, size);
}

int indexOfRange(Object o, int start, int end) {
    Object[] es = elementData;
    if (o == null) {
       ...
    } else {
        for (int i = start; i < end; i++) {
            if (o.equals(es[i])) { //calling overridden equals of the object instance, else it will revert to the Object's equals which simply compares the reference 
                return i;
            }
        }
    }
    return -1;
}