class Test {

    public static void main(String[] args) throws Exception {
        Map<Character, Runnable> commands = new HashMap<>();

        // Populate commands map
        commands.put('h', () -> System.out.println("Help"));
        commands.put('t', () -> System.out.println("Teleport"));

        // Invoke some command
        char cmd = 't';
        commands.get(cmd).run();   // Prints "Teleport"
    }
}