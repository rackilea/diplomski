// Main
List<Answer> answers = Arrays.asList(
    new Answer(new User(0)),
    new Answer(new User(20)),
    new Answer(new User(1)),
    new Answer(new User(20)),
    new Answer(new User(10))
);

answers
    .stream()
    .map(Answer::getUser)
    .collect(Collectors.toCollection(TreeSet::new))
    .forEach(System.out::println);