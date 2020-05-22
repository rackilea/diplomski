Stream.of("d2", "a2", "b1", "b3", "c")
  .filter(s -> {
        s.startsWith("b");
        System.out.println("filter: " + s);
        return true;
  })
  .forEach (System.out::println);