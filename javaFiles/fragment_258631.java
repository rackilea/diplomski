String str = "{a,b,c},{1,2,3}";
int startingIndex = str.indexOf("{");
int closingIndex = str.indexOf("}");
String result1 = str.substring(startingIndex + 1, closingIndex);
System.out.println(result1);

startingIndex = str.indexOf("{", closingIndex + 1);
closingIndex = str.indexOf("}", closingIndex + 1);
String result2 = str.substring(startingIndex + 1, closingIndex);
System.out.println(result2);