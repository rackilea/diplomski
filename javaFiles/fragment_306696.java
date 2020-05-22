String userInput = /* get user input */

for (int i = 0, n = notes.length(); i < n; i++) {
    String str = notes.get(i).replaceFirst("do", userInput);
    notes.set(i, str);
}