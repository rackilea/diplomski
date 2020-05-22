public class MyProj03 {

public static void main(String[] args) throws IOException {
File file = new File("p3text.txt");

try {
    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        Person one = new Person();
        one.parseCommaDelim(line);
    }
    scanner.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
}