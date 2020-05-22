public static void printArray(int[] arr){
System.out.println("Array : ");
for(int i = 0; i< arr.length; i++){
System.out.println(arr[i]);
}

}
public static void main(String[] args) {
int[] arr = {1, -3, 78, 13, -1005};
printArray(arr);
}