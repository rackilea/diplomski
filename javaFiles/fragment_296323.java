private static final Graph.Edge[] GRAPH = getEdges("input.txt"); // <-- CHANGED THIS
private static final String START = "1"; // <-- CHANGED THIS
private static final String END = "5"; // <-- CHANGED THIS

private static Graph.Edge[] getEdges(String fileName) { // <-- ADDED THIS
    final Pattern NAME = Pattern.compile("\\w+");
    final Pattern WEIGHT = Pattern.compile("\\d+");
    List<Graph.Edge> list = new ArrayList<>();
    try {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()) {
            String source = scanner.findInLine(NAME);
            if (source != null) {
                while (true) {
                    String to = scanner.findInLine(NAME);
                    if (to == null) {
                        break;
                    }
                    int weight = Integer.valueOf(scanner.findInLine(WEIGHT));
                    list.add(new Graph.Edge(source, to, weight));
                }
            }
            if (scanner.hasNextLine()) // <-- ADDED THIS
                scanner.nextLine();
        }
    } catch (FileNotFoundException | NumberFormatException e) {
    }
    return list.toArray(new Graph.Edge[0]); // <-- ADDED THIS
}