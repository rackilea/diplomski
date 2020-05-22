private static boolean containsArray(List<int[]> list, int[] expected) {
    for(int i=0; i<list.size; i++) {
        if(deepEquals(list[i], expected) {
            return true;
        }
    }
    return false;
}