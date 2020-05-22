public static boolean atLeastNMatchingElements(final int n,
    final int[] arr1,
    final int[] arr2){

    /* check assumptions */
    assert (arr1.length == arr2.length);

    final int arrLength = arr2.length;

    { /* optimization */
        final int maxOffset = Math.max(arrLength - n, 0);
        if(arr1[maxOffset] < arr2[0] || arr2[maxOffset] < arr1[0]){
            return false;
        }
    }

    int arr2Offset = 0;
    int matches = 0;

    /* declare variables only once, outside loop */
    int compResult; int candidate;

    for(int i = 0; i < arrLength; i++){
        candidate = arr1[i];
        while(arr2Offset < arrLength - 1){
            compResult = arr2[arr2Offset] - candidate;
            if(compResult > 0){
                break;
            } else{
                arr2Offset++;
                if(compResult == 0){
                    matches++;
                    break;
                }
            }
        }
        if(matches == n){
            return true;
        }
        /* optimization */
        else if(matches < n - (arrLength - arr2Offset)){
            return false;
        }
    }
    return false;
}