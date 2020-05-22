static String[][] makeArray(String path, int columns) {
    List<String[]> rows = new ArrayList<>();
    try (Scanner in = new Scanner(new BufferedReader(new FileReader(path)))) {
        while (in.hasNextLine()) {
            String[] values = in.nextLine().split(",");
            rows.add(Arrays.copyOf(values, columns)); // ignores excessive values
        }
    } catch (IOException e) {
        throw new IllegalArgumentException("Error reading file '" + path + "': " + e, e);
    }
    return rows.toArray(new String[rows.size()][]);
}