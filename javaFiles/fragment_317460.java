Scanner input = new Scanner(System.in);
System.out.println("Please input your favorite letter");
char userLetter = input.next().charAt(0);

// get the ASCII value of the input character
int ascii = (int) userLetter;
// compute the shift (97 for lowercase, 65 for uppercase)
int shift = ascii > 90 ? 97 : 65;

int newPosition = (ascii - shift + 10) % 26;
newPosition += shift;

char newChar = (char) newPosition;
System.out.println("10 letters beyond your letter is " + newChar);