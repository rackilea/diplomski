// determine if a character has been seen
BitSet previous = new BitSet();
// determine is a character was a duplicate.
BitSet duplicate = new BitSet();
for (int i = 0; i < s.length(); i++) {
    char ch = Character.toLowerCase(s.charAt(i));
    if (previous.get(ch)) 
        duplicate.set(ch);
    else
        previous.set(ch);
}
// create a new string in a single pass without using replace etc.
StringBuilder sb = new StringBuilder(s.length());
for (int i = 0; i < s.length(); i++) {
    char ch = Character.toLowerCase(s.charAt(i));
    // replace duplicates with ) and non duplicates with (
    sb.append(duplicate.get(ch) ? ')' : '(');
}