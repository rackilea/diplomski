String returnMessage = null;

// Something is empty
if (cipherFileRead.isEmpty() || freqFileRead.isEmpty()) {
    returnMessage = "Both files must be loaded and contain text. Decryption unsuccessful.";
}

// No description type given
if (returnMessage == null && freqChooser.getSelection() == null) {
    returnMessage = "Please select decryption type. Decryption unsuccessful";
}

// Decrypt
if (returnMessage == null) {
    // Select technique
    String decryptedText = null;
    if (nearestFreq.isSelected()) {
        decryptedText = decrypter.nearestFreq(cipherFileRead, freqFileRead);
    } else if (rankingFreq.isSelected()) {
        decryptedText = decrypter.byRanking(cipherFileRead, freqFileRead);
    }

    // Write decrypted text
    file.writeToFile(decryptedText, "output.txt");

    returnMessage = "Successfully decrypted to output.txt";
}

// Show return message
JOptionPane.showMessageDialog(null, returnMessage);