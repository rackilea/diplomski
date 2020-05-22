@Override
public Mono<Void> sendEmail(EmailDto emailDto) {
    return mailReactiveClient.sendEmail(message ->
        createMessage(emailDto, emailDto.getBody(), message))
           .then(saveNotificationLog(emailDto));
}

private Mono<Void> saveNotificationLog(EmailDto emailDto) {
    return notificationLogReactiveRepository.save(NotificationLog.builder()
        ...
        .build());
}