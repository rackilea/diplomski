Scanner sc = new Scanner(System.in);
System.out.println("Start:");
// sc.nextLine();  <-- don't do that, this reads and ignore your input
sc.findInLine("(\\d\\d)\\.(\\d\\d)\\. (\\d\\d):(\\d\\d)");
try {
    MatchResult mr = sc.match();
    int month = Integer.parseInt(mr.group(2));
    int day = Integer.parseInt(mr.group(1));
    int hour = Integer.parseInt(mr.group(3));
    int minute = Integer.parseInt(mr.group(4));

    LocalDateTime start = LocalDateTime.of(2015, month, day, hour, minute);
    System.out.println(start);
} catch (IllegalStateException e) {
    System.err.println("Invalid input!");
}