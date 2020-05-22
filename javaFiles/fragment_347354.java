public static void main(String args[]) {
    for (int i = 0; i < Character.MAX_VALUE; i++) {
        if (Character.isJavaIdentifierPart(i)) {
            System.out.println("i = " + i + ": " + (char) i);
        }
    }
}