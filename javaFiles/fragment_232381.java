public class ScanTest {
    public static void main(String []args) throws FileNotFoundException {
        Scanner user_input = new Scanner(System.in);
        String filepath = getFilePath(user_input);
        String[] all_lines = readAllLines(filepath );
    }

    public static String getFilePath(Scanner user_input) {
        String filepath = user_input.next();
        System.out.println("Filepath read: " + filepath);
        return filepath;
    }

    public static String[] readAllLines(String filepath) throws FileNotFoundException {
        // TODO: implement
    }
}