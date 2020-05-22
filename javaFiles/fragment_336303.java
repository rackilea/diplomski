byte[] arr = {104, 101, 108, 108, 111};
String s = new String(arr, StandardCharsets.UTF_8);
System.out.println(s); // Prints "hello"

// Or your input string would be:
arr = {70, 97, -61, -89, 97, 100, 101};
s = new String(arr, StandardCharsets.UTF_8);
System.out.println(s); // Prints "Façade"