public static int indexOf(String [] arr, String targetItem){
    for(int i = 0 ; i < arr.length ; i++) {
        if(targetItem.equals(arr[i]))
            return i;

    }
    return -1 ;
}