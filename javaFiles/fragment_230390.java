@Bean
public IntegrationFlow fileToFile() {
    return IntegrationFlows.from(Files.inboundAdapter(new File("/tmp/in"))
                    .autoCreateDirectory(true)
                    .patternFilter("*.txt"),
            e -> e.poller(Pollers.fixedDelay(5000)))
            .transform(Transformers.fileToString())
            .transform("payload.replaceAll('\r\n', '\n')")
            .handle(Files.outboundAdapter("'/tmp/out'")
                    .autoCreateDirectory(true))
            .get();
}