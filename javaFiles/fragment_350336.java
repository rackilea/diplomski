import java.util.*;

public class Foo {
    private static final String SENTINEL = "exit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> phone = new HashMap<>();
        System.out.print("Please enter total number of entries: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int x = 0; x < n; x++) {
            System.out.print("Please enter name: ");
            String name = scanner.nextLine();
            System.out.print("Please enter phone number: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            phone.put(name, num);
        }

        String findName = "";
        while (!findName.equalsIgnoreCase(SENTINEL)) {
            System.out.print("Please enter name to find phone number or \"" + SENTINEL + "\" to exit: " );
            findName = scanner.nextLine();
            if (phone.containsKey(findName)) {
                System.out.println(findName + "=" + phone.get(findName));
            } else if (!findName.equalsIgnoreCase(SENTINEL)){
                System.out.println("not found");
            }
        } 
    }
}