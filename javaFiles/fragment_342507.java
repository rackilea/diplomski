@Bean
public IntegrationFlow flow() {
    return IntegrationFlows.from(File.inboundChannelAdapter(...))
              .split(Files.splitter())
              .channel(MessageChannels.executor(exec())
              .transform(...)
              .enrich(...)
              .transform(...)
              .resequence()
              .handle(File.outboundCHannelAdapter(...))
              .get();