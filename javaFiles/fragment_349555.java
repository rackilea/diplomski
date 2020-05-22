List<String[]> result = new ArrayList<>();
    try (BufferedReader s = new BufferedReader(new FileReader("filename"))) {
        String line;
        while ((line = s.readLine()) != null) {
            result.add(line.split(","));
        }
    } catch (IOException e) {
        // Handle IOExceptions here
    }