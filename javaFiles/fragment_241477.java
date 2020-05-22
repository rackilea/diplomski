public static void main(String... obj) {
    try (Scanner scan = new Scanner(System.in)) {
        final Pattern whiteSpace = Pattern.compile("\\s+");
        System.out.println("Type your command!");

        do {
            String[] args = whiteSpace.split(scan.nextLine().trim());

            if (args.length == 1 && "exit".equalsIgnoreCase(args[0]))
                return;

            for (int i = 0; i < args.length; i++)
                System.out.println("arg" + (i + 1) + " = " + args[i]);

            System.out.println("Type your command!");
        } while (scan.hasNext());
    }
}