public static int findNumber(int[] array, int number){
     return(helper(array, number, 0);
}

public static int helper(int[] array, int number, int leftOf){
    int half = array.length/2;
    //System.out.println(array[half]);
    if (array[half]==number){
        return(half+leftOf);
    }
    else if (array[half]<number){
        return(
      helper(Arrays.copyOfRange(array, half, array.length),number,leftOf+half));
    }
    else if (array[half]>number){
        return(
      helper(Arrays.copyOfRange(array,0,array.length/2),number,leftOf));
    }
}