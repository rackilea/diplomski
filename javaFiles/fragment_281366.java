public int indexOf(Object o) {
    if (o == null) {
        for (int i = 0; i < size; i++)
            if (elementData[i]==null)
                return i;
    } else {
        for (int i = 0; i < size; i++)
            if (o.equals(elementData[i])) // o in your case is a String while
                                          // elementData[i] is a Test
                                          // so String's equals returns false
                return i;
    }
    return -1;
}