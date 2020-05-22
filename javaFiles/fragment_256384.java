public static int menuSystem()
{
    final Scanner keyb = new Scanner(System.in);
    // ...
}

public static void main(String[] args) {
    final UnitResults myUnit = new UnitResults(3, "Java");
    int option = menuSystem();
    while (option != 6) {
        final Scanner keyb = new Scanner(System.in);
        // ...
        option = menuSystem();
    }
}