private void readArray() {
    ArrayList<Integer> row = new ArrayList<Integer>();

    for(int a = 0; a <= _height - 1; a++) {
        row.clear();
        row = myArray.get(a);
        ...
    }
}