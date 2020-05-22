String str1 = "   acc123\tdpId 123\t201 1-01-01\t2022-01-01\thello@xyz.com\tIN\t1233\t";
str1 = str1.replaceAll("^[ ]+", ""); // removing leading spaces
str1 = str1.replaceAll("[ ]+$", ""); // removing trailing spaces
String[] split = str1.split("\t", -1);

System.out.println(Arrays.toString(split));
System.out.println(split.length);