public void dumpString(String s) {
    System.out.println("Length: " + s.length()); // check their length
    System.out.println("Value: >" + s + "<"); // check trailing and leading spaces
    System.out.println("numeric value of characters:"); // check which char differs
    for (int i = 0; i < s.length(); i++) {
        System.out.print((int) s.charAt(i));
        System.out.print(' ');
    }
}