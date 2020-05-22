String strArr = "$adg$dgsd$$$brr$dhr$$$ce$twt$$$dttgdf$gdfg$$$$$";
//Print out the string
System.out.println(strArr);
String newArr = strArr.replaceAll("\\$\\$\\$\\$\\$", "");
System.out.println(newArr);
String[] arr = newArr.split("\\$\\$");
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}