final String content = new String(Files.readAllBytes(Paths.get("<PATH TO YOUR PLACE>/input.txt")));
final List<String> words = Arrays.asList(content.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").replace("\n", " ").split(" "));

final Map<String, Integer> wordlist = new HashMap<>();
words.stream()
        .map(String::toLowerCase)
        .map(String::trim)
        .filter(s -> !s.isEmpty())
        .forEach(s -> {
            wordlist.computeIfPresent(s, (s1, integer) -> ++integer);
            wordlist.putIfAbsent(s, 1);
        });

final StringBuilder sb = new StringBuilder();
wordlist.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
        .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
        )).forEach((s, integer) -> sb.append(s).append(" : ").append(integer).append("\n"));

Files.write(Paths.get("<PATH TO YOUR PLACE>/output.txt"), sb.toString().getBytes());