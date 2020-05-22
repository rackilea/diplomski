final String template = "INSERT INTO TABLE(%s,%s,%s) VALUES ('%s','%s',%s);";
    final String delimiter = ";";

    List<String> statements = new ArrayList<>();

    List<String> lines = Files.readAllLines(Paths.get("your-file.csv"));
    String[] columnNames = lines.get(0).split(delimiter);

    for (int i = 1; i < lines.size(); i++) {
        String[] values = lines.get(i).split(delimiter);
        statements.add(String.format(template, columnNames[0], columnNames[1], columnNames[2], values[0], values[1], values[2]));
    }

    Files.write(Paths.get("your-output.sql"), statements);