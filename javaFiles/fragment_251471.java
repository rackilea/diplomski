package foo.bar.baz.qux;

@Configuration
@AutoConfigureAfter(TaskExecutionAutoConfiguration.class)
public class Config {
    @Bean
    public ThreadPoolExecutor myRequestPool() {
        return (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    }
}