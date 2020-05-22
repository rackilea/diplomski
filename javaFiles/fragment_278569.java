@Bean
public IntegrationFlow mailListener() {

    SearchTermStrategy searchTermStrategy = (supportedFlags, folder) -> {
        SearchTerm search = new AndTerm(new SubjectTerm("trigger the build"),
                new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        return search;
    };

    return IntegrationFlows.from(Mail.imapInboundAdapter(receiver()))
            .log()
            .get();
}

@Bean
public ImapMailReceiver receiver() {
    return new ImapMailReceiver("imaps://usr:pwd@imap.host.com/INBOX");
}