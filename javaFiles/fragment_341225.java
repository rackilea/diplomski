private static char[] readToCharArray(int length) throws IOException {
    int read = System.in.read();
    char[] result;
    if (read == -1 || read == '\r' || read == '\n' ) {
        result = new char[length];
    } else {
        result = readToCharArray(length + 1);
        result[length] = (char) read;
    }
    return result;
}

char[] myArray = readToCharArray(0);