char currentChar = plainText.charAt(i);
String cS = currentChar+"";
currentChar = (char) ((char) (currentChar - (int)'A' + 13) % 26 + (int)'A');

if (!cS.matches("[A-Z]")) {

    cryptText.append(plainText.charAt(i));
}
else {
    cryptText.append(currentChar);
}