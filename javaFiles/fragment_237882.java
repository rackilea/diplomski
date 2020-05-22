public static void mergeHalves(String[][] array,
                               String[][] aux,
                               int start, int middle, 
                               int end, 
                               int index) {

    if (start >= end) return;

    int ls = start, le = middle, rs = middle + 1, re = end, size = end - start + 1;

    for (int i = 0; i < size; i++) {
        if (rs > re) {
            aux[i] = array[ls++];
        } else if (ls > le) {
            aux[i] = array[rs++];
        } else if (Double.parseDouble(array[ls][index]) 
                <= Double.parseDouble(array[rs][index])) {
            aux[i] = array[ls++];
        } else {
            aux[i] = array[rs++];
        }
    }

    System.arraycopy(aux, 0, array, start, size);

}