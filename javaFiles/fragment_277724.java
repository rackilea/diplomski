void reverse(String str) {
    int i = str.length() - 1;
    char[] arr = str.toCharArray();
    for(int j = arr.length - 2; j > 0; j--){
        if(arr[j] == ' '){
          swap(arr,i, j + 1);
            i = j - 1;
        }
    }
    swap(arr, i, 0);
    System.out.println( new String(arr).toString());
}