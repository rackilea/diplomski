StringBuilder finalVersion = new StringBuilder();
String currLine;
while ((currLine = scan.readLine()) != null) {
    if (currLine.length() > 3) {
        finalVersion.append("   ").append(currLine.substring(3));
    } else {
        finalVersion.append(currLine);
    }
    finalVersion.append('\n');
}