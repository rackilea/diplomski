public static void main(String[] args) {
    StringBuffer sb = new StringBuffer();
    String[] lines = StdIn.readAllLines();
    for (int i = 0; i < lines.length; i++) {
        String line = lines[i];
        char[] charArray = line.toCharArray();
        for (int j = 0; j < charArray.length; j++) {
            char c = charArray[j];
            if (c != ' '){
                sb.append(c);
            }
        }
    }
    System.out.println(sb.toString());
}