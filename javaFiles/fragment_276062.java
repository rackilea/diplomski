int [] arr = {65, 7, 1, 68, 90};
for(int i=0; i<arr.length/2; i++){
    // the following 3 lines swap between elements arr[i] and arr[arr.length-i-1]
    arr[i] = arr[i] ^ arr[arr.length-i-1];
    arr[arr.length-i-1] = arr[i] ^ arr[arr.length-i-1];
    arr[i] = arr[i] ^ arr[arr.length-i-1];
}

for(int i=0; i<arr.length; i++){
    System.out.print(arr[i]+" ");
}