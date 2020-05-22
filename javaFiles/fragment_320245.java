Pattern p=Pattern.compile("b(a+)b");
Stream.of("a", "b", "bab", "bb", "aa", "baaab")//.parallel()
      .flatMap(s-> { Matcher m=p.matcher(s);
          return m.matches()? Stream.of(m.group(1)): Stream.empty(); })
      .mapToInt(String::length)
      .forEach(System.out::println);