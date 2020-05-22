List<String> lines = new ArrayList<>();
try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
    String line;
    while ((line = br.readLine()) != null) {
        lines.add(line);
    }
}