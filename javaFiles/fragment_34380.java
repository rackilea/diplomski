String defaultAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

BufferedReader keyInputLine;
String key;
String cipher = "";
BufferedReader inputLine;
String inputText;
StringBuilder encryptedText;
StringBuilder decryptedText;

try {
    keyInputLine = new BufferedReader(new FileReader("keyword.txt"));

    while ((key = keyInputLine.readLine()) != null) {
        System.out.println("key: " + key);

        StringBuilder stringBuilder = new StringBuilder();

        // cipher is the key word plus the reverse of the alphabet
        cipher = stringBuilder.append(key).append(new StringBuilder(defaultAlphabet).reverse().toString()).toString();

        System.out.println("cipher: " + cipher);

        // remove duplicates from cipher
        cipher = removeDuplicates(cipher);

        System.out.println("replaced cipher: " + cipher);
    }

    inputLine = new BufferedReader(new FileReader("input.txt"));

    while ((inputText = inputLine.readLine()) != null) {
        System.out.println("original: " + inputText);

        encryptedText = new StringBuilder();

        for (char c : inputText.toCharArray()) {
            // find the input letter in the alphabet
            if (defaultAlphabet.indexOf(c) != -1) {
                // replace with same index from the cipher
                encryptedText.append(cipher.toCharArray()[defaultAlphabet.indexOf(c)]);
            } else {
                // if not found, use default (ex: space)
                encryptedText.append(c);
            }
        }

        System.out.println("encrypted: " + encryptedText.toString());

        decryptedText = new StringBuilder();

        for (char c : encryptedText.toString().toCharArray()) {
            // find the encrypted letter in the cipher
            if (cipher.indexOf(c) != -1) {
                // replace with same index from the cipher
                decryptedText.append(defaultAlphabet.toCharArray()[cipher.indexOf(c)]);
            } else {
                // if not found, use default (ex: space)
                decryptedText.append(c);
            }
        }

        System.out.println("decrypted: " + decryptedText.toString());
    }
} catch (IOException e) {
    e.printStackTrace();
}