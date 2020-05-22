public class Student {

    private static final char SEPARATOR = ',';
    private static final String NEWLINE = "\r\n";
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    public void addStudentInfo() throws IOException {
        Path path = Paths.get(".../student.txt");
        StringBuilder sb = new StringBuilder();
        if (!Files.exists(path)) {
            sb.append("\uFEFF")
                .append("First name").append(SEPARATOR)
                ...
                .append(NEWLINE);
        }
        sb.append(...).append(SEPARATOR).append(...).append(NEWLINE);
        Files.write(path,
            Collections.singletonList(sb),
            CHARSET,
            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }