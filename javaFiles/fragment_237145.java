Object createIntArray(List<Integer> sizes) {
    if(sizes.size() == 1) {
        return new int[sizes.get(0)];
    } else {
        Object[] objArray = new Object[sizes.get(0)];
        for(int i = 0; i < objArray.length; i++) {
           objArray[i] = createIntArray(sizes.subList(1, sizes.size());
        }
        return objArray;
    }
}