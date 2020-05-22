// copy `code` into a temporary arraylist
ArrayList<Character> possibleLetters = new ArrayList<Character>(code.length);
for (char c : code) possibleLetters.add(c);
// select randomly "without replacement"
for (int i = 0; i < 4; i++) {
    int index = random.nextInt(possibleLetters.size());
    codeLetters = possibleLetters.remove(index);
    strings.append(codeLetters);
}