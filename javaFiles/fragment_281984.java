try (BufferedReader in = Files.newBufferedReader(filePath)) {
    for (String line; (line = in.readLine()) != null; ) {
        int idx = line.indexOf(", ");
        if (idx == -1)
            throw new IllegalArgumentException("Invalid line: " + line);
        double d1, d2;
        try {
            d1 = Double.parseDouble(line.substring(0, idx));
            d2 = Double.parseDouble(line.substring(idx + 2));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid line: " + line, e);
        }
        // code using d1 and d2 here
    }
}