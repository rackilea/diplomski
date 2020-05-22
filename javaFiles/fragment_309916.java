Map<String, Integer> wordcount = new HashMap<>();
        wordcount.put("two", 20);
        wordcount.put("five", 50);
        wordcount.put("three", 30);
        wordcount.put("four", 40);
        wordcount.put("one", 10);
        wordcount.put("six", 60);
        wordcount.put("eight", 80);
        wordcount.put("twelve", 1);
        wordcount.put("nine", 90);
        wordcount.put("ten", 100);
        wordcount.put("seven", 70);
        wordcount.put("eleven", 1);
        wordcount.put("15", 1);
        wordcount.put("13", 2);
        wordcount.put("16", 4);
        wordcount.put("14", 3);
        wordcount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                )).forEach((s, integer) -> System.out.println(String.format("%s : %s", s, integer)));