public int findLast(E item)
    int index = array.length - 1;

    while (index >= 0 && (array[index] == null || comp.compare(item, array[index]) < 0)) {
        index--;      //  ^^^^^^^^^^^^^^^^^^^^^^^
    }

    return index;
}