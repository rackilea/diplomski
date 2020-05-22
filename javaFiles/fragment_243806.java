while((currentLine = reader.readLine()) != null) {
    String trimmedLine = currentLine.trim();
    if(trimmedLine.startsWith(lineToRemove))
        continue;
    writer.write(currentLine);
    writer.newLine(); // Writes a line separator.
}