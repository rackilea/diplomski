Map<Integer, String> authorNames=authors.stream()
    .collect(Collectors.toMap(
        Author::getId,
        Author::getFullName,
        (oldValue, newValue) -> oldValue));

messages.forEach(
    m -> Optional.of(m)
        .map(Message::getAuthorId)
        .map(authorNames::get)
        .map(name -> "Message id is " + m.getId() + " author is " + name)
        .ifPresent(System.out::println)
);