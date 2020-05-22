private void outputPatternList(List<String> lines) throws IOException {
    StringBuilder builder  = new StringBuilder();
    for (String line : lines) {
         builder.append(line).append("/n");
    }
    String message = builder.toString().trim();
    try (BufferedWriter out = new BufferedWriter(new FileWriter(patternList, true))) {
        out.write(message);
    }
}