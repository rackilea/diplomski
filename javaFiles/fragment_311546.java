for (int i=0; i < array1.size(); ++i) {
    array.add(array1.get(i));
    if ((i+1) % 4 == 0) {
        array.add(array2.get(i/4));
    }
}