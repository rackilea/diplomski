while (!isEnded) {
    readLine = countLines.getLine();
    if(readLine == null)
        break;
    isEnded = countLines.testLine(readLine);
}