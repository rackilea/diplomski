public void dumpString(String s) {
    System.out.println("String: " + s);
    System.out.println("Length: " + s.length());
    System.out.print("Chars: ");
    for (int i = 0; i < s.length(); i++) {
        System.out.print((int) s.charAt(i));
        System.out.print(' ');
    }
    System.out.println();
}