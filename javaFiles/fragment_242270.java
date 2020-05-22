public static void main(final String[] args) {
    char[] chars = new char[5];
    chars[2] = '9';
    System.out.printf("Original length: %d%n",String.valueOf(chars).length());
    System.out.printf("Trimmed length:  %d%n",String.valueOf(chars).trim().length());
    System.out.printf("Parsed:          %d%n",Integer.parseInt(String.valueOf(chars).trim()));
}