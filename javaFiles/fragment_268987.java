public static void smartPrintln(String string) {
    Throwable t = new Throwable();
    StackTraceElement[] stackElements = t.getStackTrace();
    int level = stackElements.length - 1; // don't forget our function adds a level
    for (int i = 0; i < level; i++) {
        System.out.print(' '); // could probably make this more efficient
    }
    System.out.println(string);
}