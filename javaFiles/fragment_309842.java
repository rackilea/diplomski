Map<String, List<String>> wordAnagramPairs = new HashMap<>();
    wordAnagramPairs.put("race", Arrays.asList("race", "care", "acre"));
    wordAnagramPairs.put("act", Arrays.asList("act", "cat"));
    wordAnagramPairs.values().stream()
                             .filter(li -> li != null && li.size() > 1)
                             .sorted(c)
                             .forEach(System.out::println);