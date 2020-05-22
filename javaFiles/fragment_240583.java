@Bean
public FtpInboundFileSynchronizer ftpInboundFileSynchronizer() {
    FtpInboundFileSynchronizer fileSynchronizer = new FtpInboundFileSynchronizer(ftpSessionFactory());
    fileSynchronizer.setDeleteRemoteFiles(false);
    fileSynchronizer.setRemoteDirectory("/");
    fileSynchronizer.setFilter(new FtpSimplePatternFileListFilter("*.xml"));
    return fileSynchronizer;
}

@Bean
@InboundChannelAdapter(channel = "ftpChannel")
public MessageSource<File> ftpMessageSource() {
    FtpInboundFileSynchronizingMessageSource source =
            new FtpInboundFileSynchronizingMessageSource(ftpInboundFileSynchronizer());
    source.setLocalDirectory(new File("ftp-inbound"));
    source.setAutoCreateLocalDirectory(true);
    source.setLocalFilter(new AcceptOnceFileListFilter<File>());
    return source;
}