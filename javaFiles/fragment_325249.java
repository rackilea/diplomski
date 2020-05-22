public class FileLister {
    public static void main(String args[]) {
        File dir = new File("/tmp/testFilter");
        String[] files = dir.list(
            new NotFileFilter(
                new OrFileFilter(
                        new PrefixFileFilter("A"),
                        new PrefixFileFilter("B")
                )
            )
        );
        listFiles(dir, files);
    }

    private static void listFiles(File rootDir, String[] files) {
        for (String fileName: files) {
            File fileOrDir = new File(rootDir, fileName);
            if (fileOrDir.isDirectory()) {
                listFiles(fileOrDir, fileOrDir.list());
            } else {
                System.out.println(fileOrDir);
            }
        }
    }
}