private static void storeFile(String id, String url, String cat, 
                              String title, String contents) {
    try (BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(
                new FileOutputStream(
                new File(path + "/" + id + ".webtrec")),"UTF8"))) {
        // write in TREC format
        out.write("...");
        out.close();
    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
}