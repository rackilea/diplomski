Object[][] convert(List<List<Object>> lists) {
    Object[][] array = new Object[lists.size()][];
    for (int i = 0; i < array.length; i++) {
        array[i] = new Object[lists.get(i).size()];
        lists.get(i).toArray(array[i]);
    }
    return array;
}