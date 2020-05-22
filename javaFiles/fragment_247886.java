String line = reader.readLine();
while (line != null) {
    if (parsedComment(line)) {
    } else if (parsedMemory(line)) {
    } else if (parsedInstruction(line)) {
    } else {
         error(...);
    }
    line = reader.readLine();
}