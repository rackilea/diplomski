public static void main(String[] args) throws Exception {
    try {
        throw new RuntimeException("Not now!");
    } catch (Exception e) {
        try {
            tryAgain();
        } catch (Exception e2) {
            e.addSuppressed(e2);
            throw e;
        }
    }
}