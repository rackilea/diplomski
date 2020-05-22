@SpringBootApplication
public class So54492871Application {

    private static final ExecutorService exec = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        SpringApplication.run(So54492871Application.class, args);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic("so54492871-1", 1, (short) 1);
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic("so54492871-2", 1, (short) 1);
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
        return args -> {
            ListenableFuture<SendResult<String, String>> future = template.send("so54492871-1", "foo");
            future.addCallback(result -> {
                System.out.println(Thread.currentThread().getName() + ":" + result);
                exec.execute(() -> {
                    ListenableFuture<SendResult<String, String>> future2 = template.send("so54492871-2", "bar");
                    future2.addCallback(result2 -> {
                        System.out.println(Thread.currentThread().getName() + ":" + result2);
                    }, ex -> {
                        System.out.println(ex.getMessage());
                    });
                });
            }, ex -> {
                System.out.println(ex.getMessage());
            });
            System.in.read();
        };
    }

}