// The loop portion of your code remains unchanged:
for (int i = 0; i < s.length(); i++) {
    if (Character.isLetter(s.charAt(i))) {
        substring += s.charAt(i);
    } else {
        arr.add(substring);
        substring = "";
    }
}
// Add this code to fix the problem:
if (!substring.isEmpty()) {
    arr.add(substring);
}