String str = "1 2 3 4";
String arr[] = str.split(" ");
int[] ans = new int[arr.length];
for (int i = 0; i < arr.length; i++) {
    ans[i] = Integer.parseInt(arr[i]);
}
System.out.println(Arrays.toString(ans));