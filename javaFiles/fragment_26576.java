public int countWord(String word, File file) {
int count = 0;
Scanner scanner = new Scanner(file);
while (scanner.hasNextLine()) {
    String nextToken = scanner.next();
    if (nextToken.equalsIgnoreCase(word))
    count++;
}
return count;
}