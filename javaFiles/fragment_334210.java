Scanner scanner = new Scanner(System.in);

StringBuilder sb = new StringBuilder();

String line;
while (!(line = scanner.nextLine()).equals("exit")) {
    sb.append(line);
}