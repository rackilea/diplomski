String word = "";
String inverse = "";
for (int index = 0; index < input.length(); index++) {
    if (input.charAt(index) == " ") {
        if ((word.length() > 0) && (word.equals(inverse))) {
            System.out.println("Palindrome: " + word);
        }
        word = "";
        inverse = "";
    } else {
        char current = input.charAt(index);
        word += current;
        inverse = current + inverse;
    }
}
if ((word.length() > 0) && (word.equals(inverse))) {
    System.out.println("Palindrome: " + word);
}