if (addToPreviousLine) {
    int previousLineIndex = formattedStrings.size() - 1;
    if (previousLineIndex > -1) {
        // Combine the previous line and current line
        String previousLine = formattedStrings.remove(previousLineIndex);
        line = previousLine + " " + line;
    }
}