public string readNthLine(string fileName, int lineNumber) {
    // Omitted: try/catch blocks and error checking in general
    // Open the file for reading etc.

    ...

    // Skip the first lineNumber - 1 lines
    for (int i = 0; i < lineNumber - 1; i++) {
        reader.readLine();
    }

    // The next line to be read is the desired line
    String retLine = reader.readLine();

    return retLine;
}