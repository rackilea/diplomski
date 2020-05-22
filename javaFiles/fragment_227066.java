Jms.messageDrivenChannelAdapter(connectionFactoryName)
    .destination(destinationName)
    .outputChannel(channelName)
    .autoStartup(false)

    .configureListenerContainer(c -> c.messageSelector("...subscription expression..."))

    .get();