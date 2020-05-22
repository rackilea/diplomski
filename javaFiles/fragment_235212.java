PATH1("path1"),
PATH2("path2");

final Path mPath;

PATHS(final String path) {
    try {
        mPath = Files.createTempDirectory(new StringBuilder("tnk").append(File.separator).append(path).toString());
    } catch (IOException e) {
        throw new ExceptionInInitializerError(e);
    }
}