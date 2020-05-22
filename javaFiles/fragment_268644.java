StringBuffer sb = new StringBuffer("hello"); // sb holds reference 
System.out.println("String before append: "+ sb.toString()); // you print the value 
addString(sb);  // you use the reference to append to the StringBuffer
System.out.println("Sting after append "+ sb.toString()); // you print the value

String s = "hello"; // s holds a refernece
System.out.println("String before append: "+ s); // you print its value
addString(s); // // the word variable would hold a new reference inside the method 
System.out.println("Sting after append "+ s); // you print its value