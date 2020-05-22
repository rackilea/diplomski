public static void main(String[] args){
    Integer array[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
    printArray(array);
    System.out.println();
    printArray(reverseRows(array));
}

public static Integer[][] reverseRows(Integer[][] array){
    Integer[][] arrayToReturn = new Integer[array.length][array[0].length];
    for(int i = 0 ; i < array[1].length; i ++){
        arrayToReturn[i] = Arrays.copyOf(array[i], array[i].length);
        Integer newFirst = arrayToReturn[i][arrayToReturn[i].length - 1];
        Integer newLast = arrayToReturn[i][0];
        arrayToReturn[i][0] = newFirst;
        arrayToReturn[i][arrayToReturn[i].length - 1] = newLast;
    }
    return arrayToReturn;
}

public static void printArray(Integer[][] array){
    for(int i = 0 ; i < array.length ; i ++){
        System.out.println(Arrays.toString(array[i]));
    }
}