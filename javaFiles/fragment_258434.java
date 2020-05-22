String[] result;
ArrayList<String> lines = new ArrayList<>();
try (BufferedReader reader = new BufferedReader(new FileReader("path"))) {
    while (reader.ready()) {
        lines.add(reader.readLine());
    }
} catch (IOException e) {
    // proper error handling
}
result = lines.toArray(new String[lines.size()]);