BufferedReader reader = new BufferedReader(
    new InputStreamReader(
        new FileInputStream(file), charsetName));
int charCount = 0;
while (reader.read() > -1) {
    charCount++;
}