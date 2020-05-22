public static void demoRethrow()throws IOException {
    try {
        // forcing an IOException here as an example,
        // normally some code could trigger this.
        throw new IOException("Error");
    }
    catch(IOException exception) {
        /*
         * Do some handling and then rethrow.
         */
        throw exception;
    }
}