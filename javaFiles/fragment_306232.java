String str = "^^^^";
String[] result = str.split("\\^", -1);
System.out.println("Number of items: " + result.length);
for (String s: result) {
    System.out.println("\"" + s+ "\"");
}