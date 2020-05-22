temp = new int [howManyEven];
    int j = 0;
    for(int i=0;i<arr.length;i++){
        if(arr[i]%2 == 0) {
            temp[j++] = arr[i];
        }
    }