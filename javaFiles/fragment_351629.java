public static void main(String[] args) {

    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    int[] xyz = new int[3];
    String[] display = new String[3];
    int answer, position;

    do {
        xyz[0] = 1 + rand.nextInt(10);
        xyz[1] = 1 + rand.nextInt(10);
        xyz[2] = xyz[0] + xyz[1];
        for (int i = 0; i < xyz.length; i++)
            display[i] = String.valueOf(xyz[i]);
        position = rand.nextInt(3);
        display[position] = "?";
        System.out.println("What is: " + display[0] + " + " + display[1] + " = " + display[2]);

        do {
            System.out.println("Please enter an integer or 'S' to stop");
            String input = scanner.nextLine();
            if (input.equals("S")) {
                scanner.close();
                System.out.println("Stopped");
                return;
            }
            else if (input.matches("\\d+")) { // \\d+ means "a digit (0-9) once or more
                answer = Integer.parseInt(input);
                break;
            }
        } while (true);

        if (answer == xyz[position])
            System.out.println("That is correct");
        else
            System.out.println("That is wrong");
    } while (true);
}