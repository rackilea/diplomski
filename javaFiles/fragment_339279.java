String str = "Good Morning";
String subStr=str.substring(0,7);
char[] arr = subStr.toCharArray();
Arrays.sort(arr); 
for(int i = arr.length - 1; i >= 0; i--) 
System.out.print(arr[i]);