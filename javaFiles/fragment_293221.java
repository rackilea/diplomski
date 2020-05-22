int x;
int arr[] = {0,1,2,3,4,5,6,7,8,9};
int len = arr.length; // saving length in a int variable

for(int a = 0; a < len / 2; a++){
  x = arr[a];                        
  arr[a] = arr[len - 1 - a];  //notice the 'len - 1' here as index starts from 0. So last element is 'length of array - 1'
  arr[len - 1 - a] = x;
}

for(int a = 0; a < len; a++){
  System.out.print(arr[a]);
}