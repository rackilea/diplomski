int arr[] = {6,5,1,0,9};
int result = 0,reverse = 0;
for (int i = 0; i < arr.length; i++) {
    result= result*10 + arr[i];
    reverse = reverse*10+arr[arr.length-1-i];
}
System.out.println(result);//number 65109
System.out.println(reverse);//number 90156