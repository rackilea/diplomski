System.out.println("Please type a phrase below and see if its a palindrome:");
Scanner keyboard = new Scanner(System.in);
String phrase = keyboard.nextLine();
keyboard.close(); // the Scanner is not re-used later, we can close it here

int counter = 0;

// consider each String (also empty) to be a palindrome,
// unless proven otherwise later on
boolean isPalindrome = true;

// it is enough to loop over n/2 characters,
// otherwise you check each pair twice
int maxIndex = phrase.length() / 2;

while (counter < maxIndex) {
    int num = phrase.length() - (counter) - 1;

    char a = phrase.charAt(counter);
    char b = phrase.charAt(num);

    ++counter;

    // we found two characters that do not match
    if (a != b) {
        // so we remember the answer
        isPalindrome = false;

        // and exit the loop since the answer cannot be "true" anymore
        break;
    }
}

// here we just check the result and print the answer
// please note that this is done outside of the loop
if (isPalindrome) {
    System.out.println("is a palindrome");
} else {
    System.out.println("is not a palindrome");
}