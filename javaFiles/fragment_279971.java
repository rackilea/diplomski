char[] arr = new char[]{'m','a','t','h','e','m','a','t','i','c','a','l','!'}; 
String str = "mathematical!";

myBufferedWriter.write(arr); // char[]
myBufferedWriter.write(new String(arr)); // String
myBufferedWriter.write(str); // String
myBufferedWriter.write(str.toCharArray()); // char[]