public String decryptFile() {
    // Something is empty
    if (cipherFileRead.isEmpty() || freqFileRead.isEmpty()) {
        return "Both files must be loaded and contain text. Decryption unsuccessful.";
    }

    // No description type given
    if (freqChooser.getSelection() == null) {
        return "Please select decryption type. Decryption unsuccessful";
    }

    // Decrypt
    // Select technique to use
    String decryptedText = null;
    if (nearestFreq.isSelected()) {
        decryptedText = decrypter.nearestFreq(cipherFileRead, freqFileRead);
    } else if (rankingFreq.isSelected()) {
        decryptedText = decrypter.byRanking(cipherFileRead, freqFileRead);
    } else {
        // Out of techniques?
        return "No decryption technique can be applied.";
        // Or if this must not happen due to context, use:
        // throw new AssertionError();
    }

    // Write decrypted text
    file.writeToFile(decryptedText, "output.txt");

    return "Successfully decrypted to output.txt";
}