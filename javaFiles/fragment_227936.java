for(int i = 0, count = 1; i < str.length(); i++, count++) {
    char ch = str.charAt(i);
    char next = i + 1 < str.length() ? str.charAt(i + 1) : (char) -1;
    if (ch != next) {
       System.out.print("" + ch + count);
       count = 0;
    }
}