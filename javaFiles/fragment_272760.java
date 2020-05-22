List<Character> charFileContents = new ArrayList<Character>(8192);

while ((fileBuffer = stream.read())!= -1) {
    charFileContents.add((char) fileBuffer); // <-- Do the cast before storing the value
    System.out.print(fileBuffer);
}