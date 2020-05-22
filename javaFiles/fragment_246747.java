String test = "6:8.0 7:36.0 14:9.0 15:31.0 22:5.0 23:21.0 30:2.0 31:12.0 38:40.0 39:137.0 46:50.0 47:133.0 54:35.0 55:106.0 62:16.0";

String[] splitString1 = test.split(" ");
String[] splitString2 = null;

for(String a : splitString1)
{
    splitString2 = a.split(":");
    System.out.println(splitString2[0]);
    System.out.println(splitString2[1]);
    //push splitString2[0] to x
    //push splitString2[1] to y
}