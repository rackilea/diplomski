Pattern p=Pattern.compile("b(a+)b");
Stream.of("a", "b", "bab", "bb", "aa", "baaab")//.parallel()
      .map(p::matcher)
      .filter(Matcher::matches)
      .mapToInt(m->m.end(1)-m.start(1))
      .forEach(System.out::println);