public static String readFileAsString(List<String> Lines, String file) {
    String line, results = "";
    try {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        // readLine() zwraca nulla na koncu pliku, stad zabezpieczenie
        while ((line = reader.readLine()) != null) {
            results += line;
            lines.add(line);
        }
        reader.close();
        // return results;
    } catch (IOException e) {
        System.err.println("Error");
    }
    return results;
}