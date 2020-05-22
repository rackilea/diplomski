private static final char polybiusSquare[][] = { 
    { 'A', 'B', 'C', 'D', 'E', 'F' },
    { 'G', 'H', 'I', 'K', 'L', 'M' },
    { 'N', 'O', 'P', 'Q', 'R', 'S' },
    { 'T', 'U', 'V', 'W', 'X', 'Y' },
    { 'Z', 'E', 'T', 'A', 'O', 'N' },
    { 'E', 'T', 'A', 'O', 'N', 'M' } 
};

public static String decrypt (String crypt) {
    int len = crypt.length(); 
    StringBuilder plain = new StringBuilder (len / 2);

    for (int i = 0; i < len; i += 2) {
        int rowIndex = crypt.charAt(i) - '0' - 1;
        int colIndex = crypt.charAt(i + 1) - '0' - 1;
        plain.append(polybiusSquare[rowIndex][colIndex]);
    }

    return plain.toString();
}