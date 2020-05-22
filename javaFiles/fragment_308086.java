if (arr == null || !chack4and5(arr) || arr[arr.length-1] == 4 || !TwoFours(arr)) {
  throw new IllegalArgumentException(
        "Please enter a legal array which matches the pre- conditions");
}
int k=0;

for(int i = 0; i<=arr.length-1; i++){
    if (arr[i] == 4){
        int place= pos(arr,k);
        arr[place]=arr[i+1];
        arr[i+1]=5;
        k=k+3;
    }
}
return arr;