private static int findFreqArray(String[] arr, char c){
    int count = 0;
    for(int i=0;i<arr.length;i++) {
        for(char ch : arr[i].toCharArray()){
            if(ch == c)
                count++;
        }
    }
    return count;  
}