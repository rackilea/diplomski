public static class DicEntry {
    String key;
    String[] syns;
    Pattern pattern;

    public DicEntry(String key, String... syns) {
        this.key = key;
        this.syns = syns;
        pattern = Pattern.compile(".*(?:" + Stream.concat(Stream.of(key), Stream.of(syns))
                .map(x -> "\\b" + Pattern.quote(x) + "\\b")
                .collect(Collectors.joining("|")) + ").*");
    }
}

public static void main(String args[]) throws ParseException, IOException {
    // Initialization
    List<DicEntry> synonymMap = populateSynonymMap();
    Scanner scanner = new Scanner(System.in);
    // End Initialization
    System.out.println("Welcome To DataBase ");
    System.out.println("What would you like to know?");

    System.out.print("> ");
    String input = scanner.nextLine().toLowerCase();
    boolean found;
    for (DicEntry entry : synonymMap) {
        if (entry.pattern.matcher(input).matches()) {
            found = true;
            System.out.println(entry.key);
            parseFile(entry.key);
        }
    }
}

private static List<DicEntry> populateSynonymMap() {
    List<DicEntry> responses = new ArrayList<>();
    responses.add(new DicEntry("test", "test load", "quantity of test", "amount of test"));
    responses.add(new DicEntry("textbook name", "name of textbook", "text", "portfolio"));
    responses.add(new DicEntry("professor office", "room", "post", "place"));
    responses.add(new DicEntry("day", "time", "date"));
    responses.add(new DicEntry("current assignment", "homework", "current work"));
    return responses;
}