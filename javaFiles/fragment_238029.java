List<String> strings = Arrays.asList("abc\\xyz 2 5", "abc\\\\xyz 1 8",
      "abc\\\\xyz 1 9", "abc\\\\xyz 1 7", "abc\\\\xyz 1 3");

   strings = strings.stream()
       .sorted(Comparator.comparing(s -> Long.valueOf(s.replaceAll(".*\\s+", ""))))
       .collect(Collectors.toList());

   System.out.println(strings);