Scanner scan = new Scanner(new File("dataset1.csv"));
    List<String> lines = new ArrayList<>();
    while (scan.hasNextLine()) {
        String line = scan.nextLine();
        // If line is not a comment or empty
        if (!line.startsWith("#") && !line.trim().isEmpty()) {
            lines.add(line);
        }
    }
    scan.close();
    // Go through half the lines
    for (int i = 0; i < lines.size() / 2; ++i) {
        String line = lines.get(i);
        String[] split = line.split("\\s+");  // split on whitespace
        double avg_rss12 = Double.parseDouble(split[1]);
        System.out.println(avg_rss12);
    }