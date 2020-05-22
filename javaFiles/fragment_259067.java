List<Message> filterMessages(List<Message> messageStorage) {
    String filteringOption = filterOption();
    String userInput = filterValue();
    Map<String, BiPredicate<String, Message>> criteria = ImmutableMap.of(
            "title", (userTitle, message) -> userInput.equals(message.getTitle()),
            "author", (userAuthor, message) -> userInput.equals(message.getAuthor()),
            "content", (userContent, message) -> userInput.equals(message.getContent()),
            "date", (userDate, message) -> userInput.equals(message.getCreationDate())
    );

    return messageStorage.stream()
            .filter(m -> criteria.get(filteringOption).test(userInput, m))
            .collect(Collectors.toList());
}