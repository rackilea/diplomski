private static void makeLocalFile(String outPath, InputStream is) {
    try {
        InputStream is;
        File fileOut = new File(outPath);
        OutputStream out;
        out = FileUtils.openOutputStream(fileOut);
        IOUtils.copy(in, out);
        in.close();
        out.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}