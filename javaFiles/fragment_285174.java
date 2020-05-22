public static boolean findFourOnes(int[][] arr){
    for(int i = 0; i < arr.length; i++){
        if(findVertical(arr, i, 0, 0)){
            return true;
        }
    }
    for(int i = 0; i < arr.length; i++){
        if(findHorizontal(arr, 0, i, 0)){
            return true;
        }
    }
    return false;
}