Scanner stdin = new Scanner(System.in);

do {
    byte x = stdin.nextByte();
    byte y = stdin.nextByte();
    char h = stdin.next().charAt(0);
    stdin.nextLine(); // read EOL
    String str = stdin.nextLine();

    System.out.printf("Output: [%s, %s, %s], %s\n", x, y, h, str);
} while (stdin.hasNextLine());