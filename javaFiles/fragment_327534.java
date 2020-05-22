if (line.endsWith("\\")) {
    addToPreviousLine = true;
    line = line.substring(0, line.length() - 1);
} else {
    addToPreviousLine = false;
}