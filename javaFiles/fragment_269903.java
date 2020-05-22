@Bean
public MessagingLogger messagingLogger(LogEntryService logEntryService) 
{
    MessagingLogger aspect = Aspects.aspectOf(MessagingLogger.class);

    aspect.setLogEntryService(logEntryService);

    return aspect;
}