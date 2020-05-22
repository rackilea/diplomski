String readNonBlankLine(BufferedReader br) {
    String line;

    while ((line = br.readLine()) != null) {
        if (line.trim().length() == 0) {
            break;
        }
    }
    return line;
}