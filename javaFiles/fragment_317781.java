public List<Message> getAllMessages() {
    return StreamSupport.stream(messageRepository.findAll().spliterator(), false)
        .map(message -> {
            Message newMessage = new Message(message.getId(), message.getMessageKey());
            localizationRepository.findAllByObjectIdAndLocalizedType(message.getId(), LocalizedType.MESSAGE)
                .forEach(localization -> {
                    newMessage.getLocalizations().add(
                        new MessageLocalization(localization.getId(),
                            localization.getLanguage(),
                            localization.getBaseText(),
                            localization.getShortText(),
                            localization.getLongText(),
                            localization.getOrderBy()));
            });
            return newMessage;
        })
        .collect(Collectors.toList());
}