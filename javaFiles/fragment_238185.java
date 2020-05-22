public static String vigenere(String plaintext, String key, boolean encrypt) {

    final int textSize = plaintext.length();
    final int keySize = key.length();

    final int groupSize1 = 'Z' - 'A' + 1; 
    final int groupSize2 = 'z' - 'a' + 1;
    final int totalGroupSize = groupSize1 + groupSize2;

    final StringBuilder encryptedText = new StringBuilder(textSize);
    for (int i = 0; i < textSize; i++) {
        final char plainChar = plaintext.charAt(i);

        // this should be a method, called for both the plain text as well as the key
        final int plainGroupNumber; 
        if (plainChar >= 'A' && plainChar <= 'Z') {
            plainGroupNumber = plainChar - 'A';
        } else if (plainChar >= 'a' && plainChar <= 'z') {
            plainGroupNumber = groupSize1 + plainChar - 'a';
        } else {
            // simply leave spaces and other characters
            encryptedText.append(plainChar);
            continue;
        }

        final char keyChar = key.charAt(i % keySize);
        final int keyGroupNumber; 
        if (keyChar >= 'A' && keyChar <= 'Z') {
            keyGroupNumber = keyChar - 'A';
        } else if (keyChar >= 'a' && keyChar <= 'z') {
            keyGroupNumber = groupSize1 + keyChar - 'a';
        } else {
            throw new IllegalStateException("Invalid character in key");
        }

        // this should be a separate method
        final int cipherGroupNumber;
        if (encrypt) {
            cipherGroupNumber = (plainGroupNumber + keyGroupNumber) % totalGroupSize;
        } else {
            // some code to go around the awkward way of handling % in Java for negative numbers
            final int someCipherGroupNumber = plainGroupNumber - keyGroupNumber;
            if (someCipherGroupNumber < 0) {
                cipherGroupNumber = (someCipherGroupNumber + totalGroupSize);
            } else {
                cipherGroupNumber = someCipherGroupNumber;
            }
        }

        // this should be a separate method
        final char cipherChar;
        if (cipherGroupNumber < groupSize1) {
            cipherChar = (char) ('A' + cipherGroupNumber);
        } else {
            cipherChar = (char) ('a' + cipherGroupNumber - groupSize1);
        }
        encryptedText.append(cipherChar);
    }

    return encryptedText.toString();
}