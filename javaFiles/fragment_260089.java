String str="second,b,c,d,e,c";
str = str.replaceAll("[\n\r]", "");
String[] array=str.split(",");

for(int i=0;i<array.length;i++)
     System.out.println(array[i]);