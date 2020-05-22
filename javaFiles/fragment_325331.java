byte[] bytes = Files.readAllBytes(Paths.get(csvDirectory, filename));
// First decoding: £ is represented as four characters
String content = new String(bytes, "UTF-8");

bytes = new byte[content.length()];
for (int i = content.length() - 1; i >= 0; i--) {
    bytes[i] = (byte) content.charAt(i);
}
// Second decoding: £ is represented as two characters
content = new String(bytes, "UTF-8");

bytes = new byte[content.length()];
for (int i = content.length() - 1; i >= 0; i--) {
    bytes[i] = (byte) content.charAt(i);
}
// Third decoding: £ is represented as one character
content = new String(bytes, "UTF-8");

br = new BufferedReader(new StringReader(content));

// ...