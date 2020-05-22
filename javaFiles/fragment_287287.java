public static void main(String[] args) {
    File file = new File("has_been_run");
    if (!file.exists()) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // first time
    } else {
        // subsequent times
    }
}