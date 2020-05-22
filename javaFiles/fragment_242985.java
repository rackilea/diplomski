Scanner input = new Scanner(System.in);
List<String> lines = new ArrayList<>();
while (input.hasNextLine()) {
    String line = input.nextLine();
    if (line.isEmpty()) {
        break;
    } else if (line.matches("\\d+\\s+\\d+\\s+\\d+")) {
        lines.add(line);
    }
}
int count = lines.size();
for (int i = 0; i < count; i++) {
    String[] tokens = lines.get(i).split("\\s+");
    int a = Integer.parseInt(tokens[0]), m = Integer.parseInt(tokens[1]), 
            n = Integer.parseInt(tokens[2]);
    int result = (int) ((Math.pow(a, m)) % n);
    System.out.printf("(%d ^ %d) %% %d = %d%n", a, m, n, result);
}