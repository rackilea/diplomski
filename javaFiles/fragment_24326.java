List<Task> res = convert(Arrays.asList(
  new Task(LocalDate.parse("2015-01-01"), LocalDate.parse("2015-01-31"), 
        Arrays.asList("A", "B")),
  new Task(LocalDate.parse("2014-01-01"), LocalDate.parse("2014-01-31"), 
        Arrays.asList("A", "B")),
  new Task(LocalDate.parse("2015-01-15"), LocalDate.parse("2015-02-15"), 
        Arrays.asList("C"))));
res.stream().forEach(System.out::println);