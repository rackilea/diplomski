Scanner scan = new Scanner(System.in);
System.out.print("Type text: ");
String str = scan.nextLine();
int[] count = new int[26];
for (int i = 0; i < str.length(); i++) {
    char ch = Character.toLowerCase(str.charAt(i)); // not case sensitive
    if (ch >= 'a' && ch <= 'z') { // don't count "spaces" (or anything non-letter)
        count[ch - 'a']++; // as 'a' + 1 == 'b', so 'b' - 'a' == 1
    }
}
for (int i = 0; i < count.length; i++) {
    if (count[i] != 0) {
        System.out.printf("%c=%d ", 'a' + i, count[i]);
    }
}
System.out.println();