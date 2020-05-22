public static void changenumber(String fileName) throws IOException {
    ArrayList<String> lines = new ArrayList<>();
    try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
        for (String line; (line = in.readLine()) != null; ) {
            lines.add(line);
        }
    }
    int i = Integer.parseInt(lines.get(0));
    i++;
    lines.set(0, Integer.toString(i));
    writenumber(lines, fileName);
}

public static void writenumber(List<String> lines, String fileName) throws IOException {
    try (PrintWriter out = new PrintWriter(new FileWriter(fileName, true))) {
        for (String line : lines) {
            out.println(line);
        }
    }
}