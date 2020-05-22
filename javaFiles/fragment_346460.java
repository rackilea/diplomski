Scanner input = new Scanner(System.in);
String str = input.nextLine().toLowerCase();

int[] occurrences = new int[26];

// go through all the characters in the input string
for(char ch : str.toCharArray())
    if(ch >= 'a' && ch <= 'z') // 'ch' is a valid character in the alphabet
        occurrences[ch-'a']++; // increase the occurrence of 'ch'

// go through the the alphabet
for(int i = 0; i < 26; i++) {
    System.out.print((char)('a'+i) + ": "); // print the i-th character in the alphabet
    // occurrences[i] contains the number of occurrences of the i-th character
    for(int j = 0; j < occurrences[i]; j++)
        System.out.print("*"); // print '*' for every occurrance of the i-th character
    System.out.println(); // separate with new line
}
input.close(); // close scanner