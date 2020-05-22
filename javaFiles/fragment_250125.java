public class Example {
    public static void main(final String... args) {
        String input = new Scanner(System.in).nextLine();

        for (int length = input.length(); length > 0; length--) {
            for (int start = 0; start <= (input.length()-length); start++) {
                System.out.println(input.substring(start, start+length));
            }
        }
    }
}