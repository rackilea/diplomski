Scanner sc = new Scanner(System.in);
System.out.println("Enter a sentence");
String s = sc.nextLine();
String str = s.toLowerCase();
String[] words = str.split(" ");   // Split the sentence into an array of words.

for(String ss : words){
    char previousChar = '\u0000';
    for (char c : ss.toCharArray()) {
        if (previousChar == c) {    // Same character has occurred
            System.out.println(ss);
            break;
        }
        previousChar = c;
    }
}