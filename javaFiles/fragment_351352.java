public final class FileUtils {
    private FileUtils() {
    }

    public static String readFileEntry(final Path path, final String entryKey) throws IOException { }

    public static String readAndModifyFileEntry(final Path path, final String entryKey, final UnaryOperator<String> operator) throws IOException { }
}