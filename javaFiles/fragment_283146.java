// User inputs first word
System.out.print("Enter your first word: ");
String word1 = scan.next();

// User inputs second word
System.out.print("Enter your second word: ");
String word2 = scan.next();
if (word1.length() < word2.length()) {
    System.out.printf("%s is shorter than %s%n", word1, word2);
} else if (word1.length() > word2.length()) {
    System.out.printf("%s is longer than %s%n", word1, word2);
} else {
    System.out.printf("%s is the same length as %s%n", word1, word2);
}