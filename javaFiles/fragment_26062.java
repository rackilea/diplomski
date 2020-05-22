// I am assuming this function returns the 
// 0th-indexed element of the array.
public static int getLastElement(int[] array) {
    return array[0];    
}

public static int isSymmetric(int[] array) {
    if(array.length <= 1) return 1;

    // check if the first and the last element are equal
    if(getLastElement(array) == array[array.length -1])

        // copy the remaining array (leaving first and last element)
        return isSymmetric(Arrays.copyOfRange(array, 1, array.length-1));

    return 0;
}


public static void main (String[] args) { 
    int array[] = { 1, 2, 3, 2, 1 }; 

    if (isSymmetric(array) == 1) 
        System.out.println( "true"); 
    else
        System.out.println( "false"); 
}