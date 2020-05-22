public class Main {
    //These constant fields are from .nextLine() method in the Scanner class
    private static final String LINE_SEPARATOR_PATTERN ="\r\n|[\n\r\u2028\u2029\u0085]";

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(Pattern.compile(LINE_SEPARATOR_PATTERN));
        System.out.print("Enter name:");
        String name = scanner.next();
        System.out.println(name);
    }
}