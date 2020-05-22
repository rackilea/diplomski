boolean ignoreLetterCase = true;  // ignore Letter Case by default
String lineToRemove = "computer";
String criteria = ignoreLetterCase ? lineToRemove.toLowerCase() : lineToRemove;

while ((line = r1.readLine()) != null) {
    String procString = ignoreLetterCase ? line.toLowerCase : line;
    if (!procString.startsWith(criteria)) {
        w1.write(line);
        w1.newLine();
    }
}