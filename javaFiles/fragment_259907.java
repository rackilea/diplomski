public static void main(String[] args) {
    boolean[] array1 = new boolean[] {true,true,false};
    boolean[] array2 = new boolean[] {true,false,false};
    boolean[] array3 = new boolean[] {true,false,false};
    boolean[] array4 = new boolean[] {true,false,false};

    compareAndPrintCommonIndicesForArrays(array1, array2, array3);
}

public static boolean compareAndPrintCommonIndicesForArrays(boolean[] ...arrays) {
    boolean result =true;
    boolean itemToCompare;
    int elementsToCompare = arrays[0].length;

    for(int itemIndex=0; itemIndex<elementsToCompare; itemIndex++) {
        result = true;
        itemToCompare = arrays[0][itemIndex];
        for(int arrayIndex = 0; arrayIndex<arrays.length;arrayIndex++) {
            if(itemToCompare != arrays[arrayIndex][itemIndex]) {
                result = false;
            }
        }
        if(result) System.out.println(itemIndex);
    }
    return result;
}