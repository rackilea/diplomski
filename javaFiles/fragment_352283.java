private static void methodA() {
    try {
        methodB(); // throws IOException
    }
    catch (IOException ex) {

    }
}