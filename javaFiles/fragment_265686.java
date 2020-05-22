File f = ... // file to read

try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8))) {

    // regular expression checking the format of each line
    Pattern linePattern = Pattern.compile("(\\d+)(?:\\s+(\\d+):(\\d+))*");
    // regular expression to find the index (first number) in a line
    Pattern indexPattern = Pattern.compile("(\\d+)");
    // regular expression to find the vertices (a:b) in a line
    Pattern relationPattern = Pattern.compile("(\\d+):(\\d+)");

    String line;
    while ((line = reader.readLine()) != null) {

        if (linePattern.matcher(line).matches()) {

            Matcher indexMatcher = indexPattern.matcher(line);
            if (indexMatcher.find()) {
                int sourceVertex = Integer.parseInt(indexMatcher.group(1));
                // do something with the sourceVertex 

                Matcher relationMatcher = relationPattern.matcher(line);
                while (relationMatcher.find()) {
                    int destinationVertex = Integer.parseInt(relationMatcher.group(1));
                    int weight = Integer.parseInt(relationMatcher.group(2));
                    // do something with destinationVertex and weight
                }
            }
        }
    }
}