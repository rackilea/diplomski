public class Main {

    public static void main(String[] args) {

        final int MAX = 10;

        Scanner userInput = new Scanner(System.in);

        List<Person> names = new ArrayList<Person>();

        System.out.println("Welcome to name sorter program!\n");

        for (int i = 0; i < MAX; i++) {
            System.out.println("Enter person " + (i + 1) + ":");
            names.add(new Person(userInput.nextLine()));
        }

        userInput.close();

        Collections.sort(names);

        System.out.println("\nSorted Names Are...");

        for (Person name : names)
            System.out.println(name);
    }

}