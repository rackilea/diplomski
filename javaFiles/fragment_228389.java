@Bean
public IntegrationFlow fileFlow1() {
    return IntegrationFlows.from("fileFlow1Input")
            .handle(Files.outboundAdapter(tmpDir.getRoot()),
                        c -> c.id("fileWriting").autoStartup(false))
                .get();
    }