String text = "0123hello9012hello8901hello7890";
String word = "hello";

System.out.println(text.indexOf(word)); // prints "4"
System.out.println(text.lastIndexOf(word)); // prints "22"

// find all occurrences forward
for (int i = -1; (i = text.indexOf(word, i + 1)) != -1; i++) {
    System.out.println(i);
} // prints "4", "13", "22"

// find all occurrences backward
for (int i = text.length(); (i = text.lastIndexOf(word, i - 1)) != -1; i++) {
    System.out.println(i);
} // prints "22", "13", "4"