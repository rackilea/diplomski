public int countDuplicates(int[] arr) {
    int count = 0;
    for(int i=0; i<arr.length; i++){
        boolean duplicate = false;
        for(int j=0; j<i; j++){
            if(arr[i] == arr[j])
                {
                    duplicate = true;
                    break;
                }
        }
        if(!duplicate)
            count++;
    }
    return count;
 }