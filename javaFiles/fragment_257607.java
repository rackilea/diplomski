int arr[][] = {{2, 1, 3}, {4,5,6}, {9,8,7} };
int min = arr[0][0];
for(int i=0; i<arr.length; i++) {
    if(arr[i][i]<min)
       min = arr[i][i];
}
System.out.println(min);