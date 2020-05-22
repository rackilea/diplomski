@Bean
@InboundChannelAdapter(value = "ftpChannel", poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
public MessageSource receive() {
    FtpInboundFileSynchronizingMessageSource messageSource = new FtpInboundFileSynchronizingMessageSource(synchronizer());
    ...
    return messageSource;
}