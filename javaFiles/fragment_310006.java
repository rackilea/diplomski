private static Integer[] toIntegerArray(int[] array){
    Integer[] finalArray = new Integer[array.length];
    for (int i=0; i<array.length; i++){
        finalArray[i] = array[i];
    }
    return finalArray;
}