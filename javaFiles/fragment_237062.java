boolean needsNewLine = false;
while((currentLine = reader.readLine()) != null) {
    if(currentLine.equals("")) continue;
    if (!needsNewLine) {
        needsNewLine = true;
    } else {
        writer.append('\n');
    }
    writer.append(currentLine);
}