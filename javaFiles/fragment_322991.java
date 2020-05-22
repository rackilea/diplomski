File[] files = folder.listFiles(f -> {
    try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
        String line;

        while ((line = reader.readLine() + '\n' /*very important!!!*/) != null) {
            if (line.contains(PATTERN)) return true;
        }
    } catch (IOException e) {
        // error
    }

    return false;
});