private static String mostCommonIp(String fileName) throws IOException {
    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
        return stream
            // Get the IP as String. Your code. I hope this works for you.
            .map(line -> line.replaceAll("[ ]+", " ").split(" ")[2])
            // And now we group by the IPs, so we get a Map<String,Long>
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            // Now we convert that back to a stream
            .entrySet().stream()
            // And find the entry with the highest number.
            .max(Comparator.comparing(Entry::getValue))
            // Get the actual IP out of it
            .map(Entry::getKey)
            // and return the IP with the highest count - or null if not found.
            .orElse(null);
    }
}