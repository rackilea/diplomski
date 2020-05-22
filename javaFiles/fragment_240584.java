@Bean
public IntegrationFlow ftpInboundFlow() {
    return IntegrationFlows
            .from(s -> s.ftp(this.ftpSessionFactory)
                            .preserveTimestamp(true)
                            .remoteDirectory("ftpSource")
                            .regexFilter(".*\\.txt$")
                            .localFilename(f -> f.toUpperCase() + ".a")
                            .localDirectory(this.ftpServer.getTargetLocalDirectory()),
                    e -> e.id("ftpInboundAdapter").autoStartup(false))
            .channel(MessageChannels.queue("ftpInboundResultChannel"))
            .get();
}