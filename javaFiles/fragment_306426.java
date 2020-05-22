public class ReadFile {

    public static void main(String args[]) {
        List<String[]> authDB = createLoginDB("PATH_TO_LOGIN_DB_TEXT_FILE");
        isValid(authDB, "USERNAME", "PASSWORD");
    }

    private static List<String[]> createLoginDB(String fileName) {
        List<String[]> result = null;
        try (Stream<String> linesStream = Files.lines(Paths.get(fileName))) {
            result = linesStream.map(line -> line.split(",")).collect(Collectors.toList());
        } catch (IOException e) {}
        return result;
    }

    private static boolean isValid(List<String[]> authDB, String username, String password) {
        return authDB.stream()
            .filter(fields -> fields[1].equals(username) && fields[2].equals(password))
            .findAny().isPresent();
    }
}