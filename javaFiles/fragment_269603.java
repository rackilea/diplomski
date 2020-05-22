@SpringBootApplication
public class FileChangeLineSeparator {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(FileChangeLineSeparator.class)
                .web(false)
                .run(args);
        System.out.println("Put a windows file with a .txt extension in /tmp/in,"
                + "\nthe file will be converted to Un*x and placed in"
                + "\n/tmp/out"
                + "\n\nHit enter to terminate");
        System.in.read();
        context.close();
    }

@Bean
@InboundChannelAdapter(value = "channel", poller = @Poller(fixedDelay = "1000"))
public FileReadingMessageSource getFileMessageSource() {
    FileReadingMessageSource lm = new FileReadingMessageSource();
    lm.setDirectory(new File("/tmp/in"));
    lm.setFilter(new AcceptAllFileListFilter<>());
    lm.setUseWatchService(true);
    lm.setWatchEvents(FileReadingMessageSource.WatchEventType.CREATE);
    return lm;
}

@Bean
public IntegrationFlow fileToFile() {
    return IntegrationFlows.from("channel")                 
                .transform(Transformers.fileToString())
                .transform("payload.replaceAll('\r\n', '\n')")
                .handle(Files.outboundAdapter("'/tmp/out'")
                        .autoCreateDirectory(true))
                .get();
    }

}